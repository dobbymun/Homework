<template>
  <!-- onsubmit은 <form> 태그 내부에서 <input(button) type="submit">로 인해 발생하는 이벤트를 처리할 수가 있습니다.
  한마디로 해당 태그 안에 있는 내용들이 제출 대상이 된다는 의미인듯 -->
  <form @submit.prevent="onSubmit">
    <table>
      <tr>
        <td>제목</td>
        <td>
          <input type="text" v-model="title">
        </td>
      </tr>
      <tr>
        <td>작성자</td>
        <td>
          <input type="text" v-model="writer">
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
      <button type="submit">등록</button>
      <router-link to="{ name: 'JpaBoardListView' }">
        취소
      </router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: "JpaBoardRegisterForm",
  data () {
    return {
      title: '제목을 입력하세요',
      writer: '너님은 누군가요 ?',
      content: '본문을 작성하세요',
    }
  },
  methods: {
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>

<style scoped>
</style>