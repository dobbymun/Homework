import {
    REQUEST_DATA_FROM_SPRING,
    REQUEST_MONSTER_FROM_SPRING,
    REQUEST_RANDOM_SHOP_ITEM,
    //  REQUEST_CHARACTER_FROM_SPRING,
    REQUEST_MANY_RANDOM_MONSTER,
    REQUEST_RANDOM_MONSTER,
    REQUEST_MY_INVENTORY,
    REQUEST_EQUIP_ITEM,
    REQUEST_CHARACTER_STATUS_FROM_SPRING,
    REQUEST_MONSTER_STATUS_FROM_SPRING,
} from './mutation-types'            //mutation-types 파일에서 가져오는 const 상수

export default {
    [REQUEST_DATA_FROM_SPRING] (state, passingData) {      // SPRING_REQUEST 라고 명칭해주기, 어디서 요청오는건지 명시 필요(파이썬인지, 스프링인지 등등)
        state.springFromVueTestValue = passingData
    },

    [REQUEST_RANDOM_SHOP_ITEM] (state, passingData) {
        state.randomShopItem = passingData
    },

    [REQUEST_MONSTER_FROM_SPRING] (state, passingData) {
        state.monsterValue = passingData
    },

    [REQUEST_RANDOM_MONSTER] (state, passingData) {
        state.randomMonsterValue = passingData
    },

    [REQUEST_MANY_RANDOM_MONSTER] (state, passingData) {
        state.manyRandomMonsterValue = passingData
    },
    [REQUEST_MY_INVENTORY] (state, passingData) {
        state.myInventory = passingData
    },
    [REQUEST_EQUIP_ITEM] (state, passingData) {
        state.myEquipItem = passingData
    },

    [REQUEST_CHARACTER_STATUS_FROM_SPRING] (state, passingData) {
        state.characterStatus = passingData
    },

    [ REQUEST_MONSTER_STATUS_FROM_SPRING] (state, passingData) {
        state.monsterStatus = passingData
    },


}
