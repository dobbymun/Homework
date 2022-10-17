<template>
  <div>
    <market-manager/>
    <inventory-manager/>
    <experience-manager/>
    <character-manager/>
    <skill-manager/>
    <monster-manager/>

  </div>
</template>

<script>
import MonsterManager from "@/components/basics/RpgGame/MonsterManager";
import CharacterManager from "@/components/basics/RpgGame/CharacterManager";
import MarketManager from "@/components/basics/RpgGame/MarketManager";
import InventoryManager from "@/components/basics/RpgGame/InventoryManager";
import ExperienceManager from "@/components/basics/RpgGame/ExperienceManager";
import SkillManager from "@/components/basics/RpgGame/SkillManager";

export default {
  name: "MonsterGameView",
    components: {
      'monster-manager': MonsterManager,
      'character-manager': CharacterManager,
      'market-manager': MarketManager,
      'inventory-manager': InventoryManager,
      'experience-manager': ExperienceManager,
      'skill-manager': SkillManager,

    },
  data () {
    return {
    }
  },
  methods: {

  }
}

//캐릭터 정보 버튼이 아니라 그냥 화면 출력할때 불러와지려면 초기값 셋팅하는 mounted에 넣어줘야함
//그리고 캐릭터의 정보가 변경될때는 비포 업데이트에 넣어주기
// -> axios 메소드를 비포업데이트에 넣어줄 때는 무한 호출하지 않도록 플래그 넣어줘서 1번만 동작하도록 하기

</script>

<style scoped>

</style>