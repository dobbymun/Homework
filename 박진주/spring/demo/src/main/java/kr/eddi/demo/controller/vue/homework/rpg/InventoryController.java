package kr.eddi.demo.controller.vue.homework.rpg;

import kr.eddi.demo.controller.vue.homework.rpg.request.RequestEquipItem;
import kr.eddi.demo.homework.entity.rpg.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static kr.eddi.demo.controller.vue.homework.rpg.RpgCharacterController.characterStatus;


@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RequestMapping("/homework")
public class InventoryController {


    @PostMapping("/inventory-equip-items")
    public String equipItemList(@RequestBody RequestEquipItem requestEquipItem) {
        log.info("장비 장착 메소드" );

        equipItems(requestEquipItem);
        log.info("잘도착했는가: "+ requestEquipItem);

        return "장비가 장착되었습니다";
    }

    public void equipItems(RequestEquipItem requestEquipItem){
        int tmpEffect = 0;

        for (int i = 0; i < requestEquipItem.getEquipitemLists().size(); i++) {
            tmpEffect += requestEquipItem.getEquipitemLists().get(i).getAtk();
        }
        // characterStatus로 변경해야 되고 itemAtk에 set하는 방식으로 ㄱㄱ
        characterStatus.setItemAtk(tmpEffect);
        characterStatus.setAtk(characterStatus.getDefaultAtk() + characterStatus.getItemAtk());
    }

}


//RequestEquipItem(equipitemLists=[Items(atk=100, description=무기 공격력 100, name=낡은 검, price=500)])

