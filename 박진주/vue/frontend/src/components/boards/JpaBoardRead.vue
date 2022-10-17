<template>
  <div>
    <table>
      <tr>
        <td>게시물 번호</td>
        <td>
          <!--에러 노트 :value 아니라 v-model로 표기했었음 -->
          <input type="text" :value="board.boardNo" readonly>
        </td>
      </tr>
      <tr>
        <td>제목</td>
        <td>
          <input type="text" :value="board.title" readonly>
        </td>
      </tr>
      <tr>
        <td>작성자</td>
        <td>
          <input type="text" :value="board.writer" readonly>
        </td>
      </tr>
      <tr>
        <td>등록일자</td>
        <td>
          <input type="text" :value="board.regDate" readonly>
        </td>
      </tr>
      <tr>
        <td>본문</td>
        <td>
          <textarea cols="50" rows="20" :value="board.content" readonly>
          </textarea>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "JpaBoardRead",
  //에러 노트 board 자체로 받아오는 것인지 boarNo인지 헷갈림
  props: {
    board: {
      type: Object,
      required: true,
    }
  }
}
</script>

<style scoped>
</style>