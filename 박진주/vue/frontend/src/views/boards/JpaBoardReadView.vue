<template>
  <div align="center">
    <h2>Vue + Spring 게시판 읽기</h2>
    <!--에러 노트 v-if="board" 빼먹었었음 -->
    <jpa-board-read v-if="board" :board="board"/>                              <!-- 여기서 board는 computed에 써있는 변수 -> 형식:  :객체="states에 있는 변수" -->
    <p v-else>Loading .......</p>
    <router-link :to="{ name: 'JpaBoardModifyView', params: { boardNo } }">     <!--  게시물 수정 버튼을 누르면 JpaBoardModifyView 화면으로 넘어가는데 boardNo를 전달한다 -->
      게시물 수정
    </router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'JpaBoardListView' }">                             <!-- 돌아가기 할때는 리스트뷰 화면으로 보내는데 파라미터는 필요없지 -->
      돌아가기
    </router-link>
  </div>
</template>

<script>
import JpaBoardRead from "@/components/boards/JpaBoardRead";
import {mapActions, mapState} from "vuex";
export default {
  name: "JpaBoardReadView",
  components: {JpaBoardRead},

  // 여기서 props는 JpaBoardList(상위)로 하여 받아오는 값
  // 게시판 리스트에서 제목 누르는 부분에서 연결되어 받아오는 params로 예상 -> 아래는 해당 내용
  // <router-link :to="{ name: 'JpaBoardReadView', params: { boardNo: board.boardNo.toString() }}">
  // {{board.title}}
  // </router-link>
  props: {
    boardNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['board'])
  },
  methods: {
    ...mapActions([
      'requestBoardFromSpring',
      'requestDeleteBoardToSpring',
    ]),
    async onDelete () {
      await this.requestDeleteBoardToSpring(this.boardNo);
      await this.$router.push({ name: 'JpaBoardListView' })             // 삭제후 리스트 화면으로 바로 전환되도록
    }
  },
  created() {                                     // 화면 첫 로드될때 해당 boardNo 게시글의 read메소드 실행
    this.requestBoardFromSpring(this.boardNo)
  }
}
</script>

<style scoped>
</style>