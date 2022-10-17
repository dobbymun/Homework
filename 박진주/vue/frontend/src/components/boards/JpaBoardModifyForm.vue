<template>
  <div>
    <form @submit.prevent="onSubmit">
      <table>
        <tr>
          <td>게시물 번호</td>
          <td>
            <input type="text" :value="board.boardNo" disabled>
          </td>
        </tr>
        <tr>
          <td>제목</td>
          <td>
            <input type="text" v-model="title">        <!--수정 가능한 항목은 v-model -->
          </td>
        </tr>
        <tr>
          <td>작성자</td>
          <td>
            <input type="text" :value="board.writer" disabled>
          </td>
        </tr>
        <tr>
          <td>등록일자</td>
          <td>
            <input type="text" :value="board.regDate" disabled>
          </td>
        </tr>
        <tr>
          <td>본문</td>
          <td>
            <textarea cols="50" rows="20" v-model="content">
            </textarea>
          </td>
        </tr>
      </table>

      <div>
        <button type="submit">수정 완료</button>
        <router-link :to="{ name: 'JpaBoardReadView',
                            params: { boardNo: board.boardNo.toString() } }">  <!-- url 인경우는 문자열을 보내야 하므로 .toStirng()으로 보낸다고 함(?)/ 숫자로 보내도 상관없을때는 .toString()사용하지 않음-->
          취소
        </router-link>
      </div>

    </form>
  </div>
</template>

<script>
export default {
  name: "JpaBoardModifyForm",

  //상위 컴포넌트는?JpaBoardModifyView

  // type은 object 객체이며 , 꼭 값이 필요하다는 의미

  props: {
    board: {
      type: Object,
      required: true,
    }
  },

  data () {
    return {
      title: '',
      content: '',
      writer: '',
      regDate: '',
    }
  },
  created () {
    this.title = this.board.title
    this.writer = this.board.writer
    this.content = this.board.content
    this.regDate = this.board.regDate
  },
  methods: {
    onSubmit () {
      const { title, content, writer, regDate } = this
      this.$emit('submit', { title, content, writer, regDate })
    }
  }
}
</script>

<style scoped>
</style>