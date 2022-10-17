<template>

  <button v-on:click="darknessTwilightBrightnessDawnRagnaBlade">황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드</button>

</template>


<script>

import {mapActions} from "vuex";

export default {
  name: "SkillManager",
  // props:{
  //   returnMonsterListsValue : Array,
  // },
  methods: {
    ...mapActions([
      'requestManyMonsterAttackFromSpring',
    ]),
    async darknessTwilightBrightnessDawnRagnaBlade() {
      await this.requestManyMonsterAttackFromSpring()


      // eslint-disable-next-line vue/no-mutating-props
     // this.returnMonsterListsValue = this.$store.state.multiAttackResultMonsterValue
    //  this.$emit('updateMultiAttackMonsterList', this.returnMonsterListsValue)

      console.log("여명은 빛나고 구름은 흐른다. 나 여기 주문을 외우니 망자를 구원하라! " +
             "황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드!!!!!!!!!")

      // returnMonsterListsValue를 몬스터 매니저에서 받아서 가져와야함 -> 하위 상위 컴포넌트 생각해보기

    },

    // 우선 버튼 누른다 ->스프링으로 데미지 전달
    // 스프링의 공격메소드에서 몬스터 리스트에 들어가 있는 아이들 HP깎음
    // 비포업데이트에서 몬스터 리스트 변경 감지 뿌려주기

    // darknessTwilightBrightnessDawnRagnaBlade () {
    //   console.log("여명은 빛나고 구름은 흐른다. 나 여기 주문을 외우니 망자를 구원하라! " +
    //       "황혼보다 어두운, 새벽보다 찬란한 라그나 블레이드!!!!!!!!!")
    //   for (let i = 0; i < this.monsterLists.length; i++) {
    //     this.monsterLists[i].hp -= 30 * this.characterStatus.atk
    //   }
    // }

    },


}
</script>

<style scoped>

</style>