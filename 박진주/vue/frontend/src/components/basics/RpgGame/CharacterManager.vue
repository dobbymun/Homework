<template>
  <div>
    <p>캐릭터 상태 창 (Local Component)</p>
    <p>HP: {{ characterStatus.hp }} MP: {{ characterStatus.mp }} ATK: {{ characterStatus.atk }} Lv: {{ characterStatus.level }} 직업: {{ characterStatus.currentJob }}</p>
    <p>STR: {{ characterStatus.str }} INT: {{ characterStatus.intelligence }} DEX: {{ characterStatus.dex }} VIT: {{ characterStatus.vit }} DEF: {{ characterStatus.def }} MEN: {{ characterStatus.men }}</p>
    <p>경험치: {{ characterStatus.currentLevelBar }} / {{ characterStatus.totalLevelBar }}</p>
    <p>소지금: {{ characterStatus.money }}</p>
  </div>
</template>

<script>
import {mapActions, mapState} from "vuex";
export default {
  name: "CharacterManager",
  data () {
    return { }
  },
  computed: {
    ...mapState([
      'characterStatus',
     // 'characterStatusUpdateFlag',   // states 파일에 있는 변수들->  characterStatus: {}, characterStatusUpdateFlag: false,

    ])
  },
  methods: {
    ...mapActions([
      'requestCharacterStatusFromSpring',
    ]),
  },
  async mounted () {                              // 마운티드를 통해 처음 페이지 열렸을때 requestCharacterStatusFromSpring 함수 동작되도록 걸어줌
    await this.requestCharacterStatusFromSpring()  // actions에 있는 함수로 스프링서버(postmapping)에서 캐릭터 정보 받아옴
  },
}
</script>

<style scoped>
</style>