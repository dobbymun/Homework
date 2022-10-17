package kr.eddi.demo.controller.vue.homework.rpg;

import kr.eddi.demo.homework.entity.rpg.Monster;
import kr.eddi.demo.homework.entity.rpg.MonsterBooks;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ToString
@RestController
@RequestMapping("/homework")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MonsterController {

    public List<Monster> monsterList= new ArrayList<>();

//    @GetMapping("/monster-status")
//    public List<Monster> MonsterStatus(){
//        log.info("monster 리스트 정보 보기+ 배열 사이즈: "+ Monster.appearMonsterList.size());
//
//        return Monster.appearMonsterList;
//    }


    @GetMapping("/monster-status")
    public List<Monster> runAddDefaultMonster(){
        log.info("monster 리스트 실행");
        log.info("monster 리스트 정보 보기+ 배열 사이즈: "+ Monster.appearMonsterList.size());

        defaultMonster();


        return Monster.appearMonsterList;
    }

    @GetMapping("/random-monster")
    public List<Monster> runAddRandomMonster(){
        log.info("랜덤 몬스터 실행");
        addRandomMonster();

        return Monster.appearMonsterList;
    }

    @GetMapping("/many-random-monster")
    public List<Monster> runAddManyRandomMonster(){
        log.info("랜덤 매니 몬스터 실행");
        addManyRandomMonster();

        return Monster.appearMonsterList;
    }


    public void defaultMonster(){

        if(monsterList.size() == 0){
            monsterList.add(new Monster(MonsterBooks.슬라임.ID, MonsterBooks.슬라임.NAME, MonsterBooks.슬라임.HP, MonsterBooks.슬라임.EXP, MonsterBooks.슬라임.DROP_MONEY));
            monsterList.add(new Monster(MonsterBooks.고블린.ID, MonsterBooks.고블린.NAME, MonsterBooks.고블린.HP, MonsterBooks.고블린.EXP, MonsterBooks.고블린.DROP_MONEY));
            monsterList.add(new Monster(MonsterBooks.놀.ID, MonsterBooks.놀.NAME, MonsterBooks.놀.HP, MonsterBooks.놀.EXP, MonsterBooks.놀.DROP_MONEY));
            Monster.appearMonsterList.addAll(monsterList);
        }


    }


    public void addRandomMonster(){
        int maxIdx = monsterList.size()+ 1;
     //  ex) 20개라면 0 ~ 19.xxx 까지인데 floor 버림이니까 0 ~ 19까지
      int randomMonsterBookIdx = (int) Math.floor(Math.random() * MonsterBooks.values().length);
        monsterList.add(new Monster(maxIdx, MonsterBooks.values()[randomMonsterBookIdx].NAME, MonsterBooks.values()[randomMonsterBookIdx].HP, MonsterBooks.values()[randomMonsterBookIdx].EXP, MonsterBooks.values()[randomMonsterBookIdx].DROP_MONEY));
        Monster.appearMonsterList.add(new Monster(maxIdx, MonsterBooks.values()[randomMonsterBookIdx].NAME, MonsterBooks.values()[randomMonsterBookIdx].HP, MonsterBooks.values()[randomMonsterBookIdx].EXP, MonsterBooks.values()[randomMonsterBookIdx].DROP_MONEY));

        log.info("랜덤 몬스터 잘 추가되었나: " + Monster.appearMonsterList.get(0).getName()+ "랜덤몬스터 사이즈: "+Monster.appearMonsterList.size() );
        log.info("랜덤몬스터 추가 id: "+ maxIdx +"랜덤몬스터 이름: "+ MonsterBooks.values()[randomMonsterBookIdx].NAME);
    }

    public void addManyRandomMonster(){
        for (int i = 0; i < 100; i++) {
       addRandomMonster();
      }

    }

}
