package kr.eddi.demo.controller.vue.homework.rpg;

import kr.eddi.demo.homework.entity.rpg.Character;
import kr.eddi.demo.homework.entity.rpg.Monster;
import kr.eddi.demo.homework.entity.rpg.Skill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RequestMapping("/homework")
public class SkillController {

    public static Skill skill = new Skill();

    @GetMapping ("/multi-monster-attack")
    public Boolean multiMonsterAttack(){
        log.info("멀티 몬스터 공격메소드 실행");


        return skill.doMultiAttack();
    }




}

      //  List<Integer> monsterHpList = new ArrayList<>();
//        monsterHpList.add(Monster.appearMonsterList.get(i).getHp());
//        Iterator monster =  monsterHpList.iterator();
//        while(monster.hasNext()){
//            if( <= 0){
//
//            }
//        }
//

//        for (int i = 0; i < Monster.appearMonsterList.size(); i++)  {
//            Monster.appearMonsterList.remove(i);
//        }




// darknessTwilightBrightnessDawnRagnaBlade () {
//
//   for (let i = 0; i < this.monsterLists.length; i++) {
//     this.monsterLists[i].hp -= 30 * this.characterStatus.atk
//   }
// }