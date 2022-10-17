<template>
  <div align="center">
    <h2>Vue + Spring 게시물 수정</h2>
    <jpa-board-modify-form v-if="board" :board="board" @submit="onSubmit"/>
    <p v-else>Loading .........</p>
  </div>
</template>
<!--
   (1) :board="board"에서 형식은 -> :하위 컴포넌트에서 정의한 props 속성 이름 = "하위 컴포넌트에 전달할 상위 컴포넌트의 data 속성"
   (2) v-if="board" & :board="board"에서 대입되는 오른쪽 board값은 computed: states에서 가져온값
   (3) 여기서 "onSubmit"은 하위 컴포넌트인 JpaBoardModifyForm에서 emit한 값을 ( this.$emit('submit', { title, content, writer, regDate }))
    'submit'이라는 이벤트로 명명해서 전달했으므로 @submit으로 적어주고 onSubmit 메소드로 전달
    (4) 아래 onSubmit(payload) 메소드 작성해서 연결
    -->

<script>
import JpaBoardModifyForm from "@/components/boards/JpaBoardModifyForm";
import {mapActions, mapState} from "vuex";
export default {
  name: "JpaBoardModifyView",
  components: {JpaBoardModifyForm},

  //JpaBoardModifyView에서 상위란?
  // -> 게시물 수정버튼이 있는 JpaBoardReadView
  // <router-link :to="{ name: 'JpaBoardModifyView', params: { boardNo } }">
  //게시물 수정
  //</router-link>

  props: {
    boardNo: {
      type: String,
      required: true,
    }
  },
  computed: {
    ...mapState(['board'])
  },
  methods: {
    ...mapActions([
      'requestBoardFromSpring',
      'requestBoardModifyToSpring'
    ]),
    async onSubmit (payload) {
      const { title, content, writer, regDate } = payload
      const boardNo = this.boardNo
      await this.requestBoardModifyToSpring({ boardNo, title, content, writer, regDate })
      await this.$router.push({
        name: 'JpaBoardReadView',
        params: { boardNo: this.boardNo }
      })
    }
  },
  created () {                                      // 화면 첫 로드될때 해당 boardNo 게시글의  read메소드 실행
    this.requestBoardFromSpring(this.boardNo)
  }
}
</script>

<style scoped>
</style>