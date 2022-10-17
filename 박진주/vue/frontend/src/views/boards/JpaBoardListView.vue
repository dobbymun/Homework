<template>
  <div id="board">
    <h2>Vue + Spring + JPA Boards</h2>
    <!-- 에러 노트: 여기서 router-link to ="컴포넌트명"로 했더니 연결이 안되서 백지화면 나옴 :to 사용 주의-->
    <router-link :to="{ name: 'JpaBoardRegisterView' }">
      게시물 작성
    </router-link>
    <jpa-board-list :boards="boards"/>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
import JpaBoardList from "@/components/boards/JpaBoardList";
export default {
  name: "JpaBoardListView.vue",
  components: {
    JpaBoardList                            //JPABoardListView는 하위 컴포넌트인 JPABoardList를 components에 써줌
  },
  computed: {
    ...mapState([
      'boards'
    ]),
  },
  mounted() {
    this.requestBoardListFromSpring()
  },
  methods: {
    ...mapActions([
      'requestBoardListFromSpring'
    ])
  }
}
</script>

<style scoped>
</style>