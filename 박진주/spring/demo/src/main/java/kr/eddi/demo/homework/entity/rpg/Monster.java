package kr.eddi.demo.homework.entity.rpg;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Monster {

    public static List<Monster> appearMonsterList= new ArrayList<>();

    private Integer id;
    private String name;
    private Integer hp;
    private Integer exp;
    private Integer dropMoney;

    public Monster(Integer id, String name, Integer hp, Integer exp, Integer dropMoney){
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.exp = exp;
        this.dropMoney = dropMoney;
    }

}
