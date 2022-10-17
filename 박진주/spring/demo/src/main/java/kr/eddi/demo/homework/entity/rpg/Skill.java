package kr.eddi.demo.homework.entity.rpg;

import lombok.extern.slf4j.Slf4j;

import static kr.eddi.demo.controller.vue.homework.rpg.RpgCharacterController.characterStatus;

@Slf4j
public class Skill {

    public Boolean doMultiAttack(){

        Boolean MonsterDie = false;

        if(Monster.appearMonsterList != null){
            for (int i = (Monster.appearMonsterList.size()-1); i > - 1; i--) {
                Monster.appearMonsterList.get(i).setHp( Monster.appearMonsterList.get(i).getHp() - 30 * characterStatus.getAtk());
                log.info("멀티공격 적용 "+i+"번째 몬스터의 hp: "+ Monster.appearMonsterList.get(i).getHp()+ " 이름: " + Monster.appearMonsterList.get(i).getName());
                if (Monster.appearMonsterList.get(i).getHp() <= 0){
                    skillExchangeCharacterStatus(i);

                    log.info("이게 동작이 안되나?"+i+"번째에서 동작했음");
                    Monster.appearMonsterList.remove(i);
                    log.info("삭제가 안되나요?: " + Monster.appearMonsterList.toString());

                    MonsterDie = true;
                }

            }
        }
        return MonsterDie;
    }

    public void skillExchangeCharacterStatus(int monsterIdx){
        characterStatus.setCurrentLevelBar(characterStatus.getCurrentLevelBar()
                +Monster.appearMonsterList.get(monsterIdx).getExp());
        characterStatus.setMoney(characterStatus.getMoney()
                +Monster.appearMonsterList.get(monsterIdx).getDropMoney());

        if(characterStatus.getLevel() == 99){return;}
        while(characterStatus.getCurrentLevelBar() >= characterStatus.getTotalLevelBar()){
            if(characterStatus.getLevel() == 99){return;}
            characterStatus.setCurrentLevelBar(characterStatus.getCurrentLevelBar()- characterStatus.getTotalLevelBar());
            characterStatus.setLevel(characterStatus.getLevel() + 1);
            characterStatus.setHp((int) (characterStatus.getHp() * 1.05));
            characterStatus.setMp((int) (characterStatus.getMp() * 1.05));
            characterStatus.setDefaultAtk(characterStatus.getDefaultAtk()+4);
            characterStatus.setAtk(characterStatus.getDefaultAtk()+ characterStatus.getItemAtk());
            characterStatus.setDef(characterStatus.getDefaultAtk() + 1);
            characterStatus.setStr(characterStatus.getStr() +3);
            characterStatus.setIntelligence(characterStatus.getIntelligence() +1);
            characterStatus.setDex(characterStatus.getDex() +2);
            characterStatus.setVit(characterStatus.getVit() +3);
            characterStatus.setMen(characterStatus.getMen() +1);

            if (characterStatus.getLevel() < 10) {
                characterStatus.setTotalLevelBar((int) (characterStatus.getTotalLevelBar() * 1.2));
            } else if (characterStatus.getLevel() < 30) {
                characterStatus.setTotalLevelBar((int) (characterStatus.getTotalLevelBar() * 1.3));
            } else if (characterStatus.getLevel() < 50) {
                characterStatus.setTotalLevelBar((int) (characterStatus.getTotalLevelBar() * 1.1));
            } else if (characterStatus.getLevel() < 70) {
                characterStatus.setTotalLevelBar((int) (characterStatus.getTotalLevelBar() * 1.3));
            } else if (characterStatus.getLevel() < 100) {
                characterStatus.setTotalLevelBar((int) (characterStatus.getTotalLevelBar() * 1.1));
            }
        }
    }
}

