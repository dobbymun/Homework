<template>
  <div>
    <h3>게시물 목록</h3>
    <table border="1">
      <tr>
        <th align="center" width="100">No</th>
        <th align="center" width="640">제목</th>
        <th align="center" width="150">작성자</th>
        <th align="center" width="240">등록일자</th>
      </tr>

        <!--  !boards 또는 boards 배열이면서 length가 0 일때 출력해라->  여기서 ||는 or 연산자
        !boards 뜻: not boards 라는 뜻으로 boards에 값이 없는 경우를 의미합니다.
         boards에 값이 있으면 not(부정)을 하므로 false가 되고 값이 없다면 not(부정)을 하므로 true가 됩니다.
        Array.isArray(obj): 파라미터로 입력받은 obj가 배열인지 여부를 boolean값으로 리턴
        -->
      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">
          현재 등록된 게시물이 없습니다!
        </td>
      </tr>
      <tr v-else v-for="board in boards" :key="board.boardNo">  <!-- 여기서 boards는 현재파일의  props에 있는 데이터로 상위(보드리스트뷰)에서 받아오는 데이터-->
        <td align="center">
          {{ board.boardNo }}
        </td>
        <td align="left">
          <!-- 에러노트- 여기서 params: {board.boardNo.toString()}으로 boardNo: 빼고 표기했더니 readView 에서 boardNo 인식을 못해서 폼안에 내용을 못받아옴-->
          <router-link :to="{ name: 'JpaBoardReadView',
                              params: { boardNo: board.boardNo.toString() }}">      <!-- 게시판의 제목을 클릭 시  JpaBoardReadView 상세페이지 연결해서 보여 줌  -->
            {{ board.title }}
          </router-link>
        </td>
        <td align="right">
          {{ board.writer }}
        </td>
        <td align="center">
          {{ board.regDate }}
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "JpaBoardList",
  props: {
    boards: {
      type: Array                 // 현재 컴포넌트 JPABoardList의 상위 컴포넌트인 JPABoardListView에서 받아오는 데이터 props에 써줌
    }
  }
}
</script>

<style scoped>
</style>