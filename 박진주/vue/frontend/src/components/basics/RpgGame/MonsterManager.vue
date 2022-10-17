<template>
  <div>
    <h3>몬스터</h3>

    <button @click="callRequestRandomMonster" type="button">랜덤 몬스터 추가</button>
    <button @click="callRequestManyRandomMonster" type="button">랜덤 몬스터 100마리 추가</button>
    <button @click="monsterStatusFromSpring" type="button">몬스터 상태보기</button>
<!--    <skill-manager-->
<!--        @updateMultiAttackMonsterList="updateMultiAttackMonsterList"-->
<!--    />-->
<!--    <button @click="updateMultiAttackMonsterList" type="button"><button>몬스터 리스트</button><br/>-->
    <p>몬스터리스트</p>
    <ul>
      <li v-for="(monster, index) in returnMonsterListsValue" :key="index">
        몬스터 이름: {{ monster.name }}, HP: {{ monster.hp }}
      </li>
    </ul>

  </div>

</template>

<script>
import {mapActions, mapState} from "vuex";
// import SkillManager from "@/components/basics/RpgGame/SkillManager";

export default {
  name: "MonsterManager",
  // components:{
  //   'skill-manager': SkillManager,
  // },
  data () {
    return {
      returnMonsterListsValue:[],
    }
  },
  computed: {
    ...mapState([
      'monsterStatus',
      'monsterStatusUpdateFlag',   // states 파일에 있는 변수들->  monsterStatus: {}, monsterStatusUpdateFlag: false,
    ])
  },
  methods: {
    ...mapActions([
      'requestMonsterFromSpring',
      'requestRandomMonster',
      'requestManyRandomMonster',
      'requestMonsterStatusFromSpring',
    ]),

    // async callRequestMonsterFromSpring() {
    //   await this.requestMonsterFromSpring()
    //   this.returnMonsterListsValue = this.$store.state.monsterValue
    //
    // },                                                                             //mapActions는 actions.js에 있는 메소드 써주는 건데 자바로 치면 유틸리티 메소드, 액션에 배치하는 건 다 쓰레드 베이스
    async callRequestRandomMonster() {                                             // 데이터 요청이 응답보다 처리가 무겁기 때문에 async/ await를 통해 응답이 요청처리 기다리도록 만들어줌
      await this.requestRandomMonster()                                            //actons에 작성된 메소드     // 처리가 오래걸리는 요청메소드 앞에 await 써줌 -> 즉, requestDataFromSpring() 메소드 실행이 완료되면 그 다음 응답부분인 returnValue 코드 실행
      this.returnMonsterListsValue = this.$store.state.randomMonsterValue          // 응답되어 스프링에서 결과값 받아오는 부분

    },

    async callRequestManyRandomMonster() {
      await this.requestManyRandomMonster()
      this.returnMonsterListsValue = this.$store.state.manyRandomMonsterValue

    },

    async monsterStatusFromSpring() {
      await this.requestMonsterStatusFromSpring()
      this.returnMonsterListsValue = this.$store.state.monsterStatus

    },

    // updateMultiAttackMonsterList (passingValue) {
    //   console.log('멀티공격후 몬스터 리스트: ' + passingValue)
    //   this.returnMonsterListsValue = passingValue
    // },
  },

  async mounted () {
    await this.requestMonsterFromSpring()            //actons에 작성된 메소드     // 처리가 오래걸리는 요청메소드 앞에 await 써줌 -> 즉, requestDataFromSpring() 메소드 실행이 완료되면 그 다음 응답부분인 returnValue 코드 실행
    this.returnMonsterListsValue = this.$store.state.monsterValue
   // await this.requestMonsterStatusFromSpring()
  //  this.returnMonsterListsValue = this.$store.state.monsterStatus
  },

}
</script>

<style scoped>
</style>