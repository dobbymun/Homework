package kr.eddi.demo.entity.vue.rpg;

import kr.eddi.demo.controller.vue.homework.rpg.RpgCharacterController;

import kr.eddi.demo.homework.entity.rpg.Character;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import static kr.eddi.demo.controller.vue.homework.rpg.RpgCharacterController.characterStatus;

@ToString
@Slf4j
@Getter
public class ExperienceExchange {
    // "hp", "mp", "atk", "str", "dex", "int", "def"
    private Integer incrementedHp = 0;
    private Integer incrementedMp = 0;
    private Integer incrementedAtk = 0;
    private Integer incrementedStr = 0;
    private Integer incrementedDex = 0;
    private Integer incrementedInt = 0;
    private Integer incrementedDef = 0;

    private final int HP = 0;
    private final int MP = 1;
    private final int ATK = 2;
    private final int STR = 3;
    private final int DEX = 4;
    private final int INT = 5;
    private final int DEF = 6;
    private final int HP_MP_INCREMENT = 50;
    private final int OTHER_STATS_INCREMENT = 5;
    private final int EXCHANGE_EXP_POINT = 1000;

    public Boolean exchangeExperience(ArrayList<Integer> selectedLists) {
        System.out.println("여기서 경험치 교환 가능 여부 판정");
        CharacterStatus currentCharacterStatus = new CharacterStatus(characterStatus);

        boolean exchangeExpResult = false;

        int tmpTotalExchangeExp = 0;

        for (int i = 0; i < selectedLists.size(); i++) {
            if (selectedLists != null) {
                tmpTotalExchangeExp += EXCHANGE_EXP_POINT;
                log.info("경험치 교환 널값 아님: " + tmpTotalExchangeExp);
            }
        }

        if (characterStatus.getCurrentLevelBar() >= tmpTotalExchangeExp) {
            if (selectedLists != null) {
              characterStatus.setCurrentLevelBar(characterStatus.getCurrentLevelBar() - tmpTotalExchangeExp);

                    for (int i = 0; i < selectedLists.size(); i++) {
                        switch (selectedLists.get(i)) {
                            case HP:
                                incrementedHp += HP_MP_INCREMENT;
                                characterStatus.setHp(
                                        currentCharacterStatus.getHp() + incrementedHp);
                                break;

                            case MP:
                                incrementedMp += HP_MP_INCREMENT;
                                characterStatus.setMp(
                                        currentCharacterStatus.getMp() + incrementedMp);
                                break;

                            case ATK:
                                incrementedAtk += OTHER_STATS_INCREMENT;
                                characterStatus.setDefaultAtk(
                                        currentCharacterStatus.getDefaultAtk() + incrementedAtk);
                                characterStatus.setAtk(
                                        characterStatus.getDefaultAtk() + characterStatus.getItemAtk());
                                break;

                            case STR:
                                incrementedStr += OTHER_STATS_INCREMENT;
                                characterStatus.setStr(
                                        currentCharacterStatus.getStr() + incrementedStr);
                                break;

                            case DEX:
                                incrementedDex += OTHER_STATS_INCREMENT;
                                characterStatus.setDex(
                                        currentCharacterStatus.getDex() + incrementedDex);
                                break;

                            case INT:
                                incrementedInt += OTHER_STATS_INCREMENT;
                                characterStatus.setIntelligence(
                                        currentCharacterStatus.getIntelligence() + incrementedInt);
                                break;

                            case DEF:
                                incrementedDef += OTHER_STATS_INCREMENT;
                                characterStatus.setDef(
                                        currentCharacterStatus.getDef() + incrementedDef);
                                break;

                            default:
                                System.out.println("잘못된 요청");
                        }
                    }

                exchangeExpResult = true;   // 여기서 경험치 교환하는 경우 TRUE 리턴 / VUE 경험치 매니저에서 기본값 FAlSE로 셋팅
                }
            }
            return exchangeExpResult;
        }
    }

