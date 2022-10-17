import {                                 //상수일때 표기(스크리밍 스테이크 표기법 : 대문자_대문자_대문자)
    REQUEST_DATA_FROM_SPRING,
    REQUEST_MANY_RANDOM_MONSTER,
    REQUEST_MONSTER_FROM_SPRING,
    REQUEST_RANDOM_MONSTER,
    REQUEST_RANDOM_SHOP_ITEM,
    REQUEST_MY_INVENTORY,
    REQUEST_CHARACTER_STATUS_FROM_SPRING,
    REQUEST_MONSTER_STATUS_FROM_SPRING,
} from './mutation-types'

// npm install axios --save-dev
import axios from 'axios'

export default {
    requestDataFromSpring({commit}) {
        console.log("I'm from action - requestDataFromSpring()")

        return axios.get('http://localhost:7777/30th/vue2spring/test')   // 현재 스프링이 가지고 있는 url를 요청하는 것 -> 스프링은 7777서버(파이썬이면 다른 포트 번호)
            //'http://localhost:7777/30th/vue2spring/test' 는 스프링 controller에서 설정한  GetMapping 주소임
            .then((res) => {
                commit(REQUEST_DATA_FROM_SPRING, res.data.randomNumber)  //위 url을 요청 후 데이터를 받아서 res.data
            })
    },

    requestRandomGameItem({commit}) {
        console.log("requestGameItemData()")

        return axios.get('http://localhost:7777/31th/rpg-game/random-shop-item-lists')
            .then((res) => {
                commit(REQUEST_RANDOM_SHOP_ITEM, res.data)
            })
    },

    requestRandomMonster({commit}) {
        console.log("I'm from action - 랜덤몬스터스프링()")

        return axios.get('http://localhost:7777/homework/random-monster')
            .then((res) => {
                commit(REQUEST_RANDOM_MONSTER, res.data)
            })
    },

    requestManyRandomMonster({commit}) {
        console.log("I'm from action - 매니 랜덤몬스터스프링()")

        return axios.get('http://localhost:7777/homework/many-random-monster')
            .then((res) => {
                commit(REQUEST_MANY_RANDOM_MONSTER, res.data)
            })
    },
    requestBuyItem ({ commit, dispatch }, payload) {
        console.log("requestBuyItem()")

        return axios.post('http://localhost:7777/31th/rpg-game/buy-item',
            {totalPrice: payload.calculatedPrice, itemLists: payload.selectedItems})
            .then((res) => {
                alert(res.data)
                commit(REQUEST_MY_INVENTORY)
                dispatch('requestCharacterStatusFromSpring')
            })
    },
    requestMyInventory ({ commit }) {
        console.log("requestMyInventory()")

        return axios.post('http://localhost:7777/31th/rpg-game/my-inventory')
            .then((res) => {
                commit(REQUEST_MY_INVENTORY, res.data)
            })

    },
    requestEquipItem ({ dispatch }, payload) {
        console.log("requestEquipItem()")

        return axios.post('http://localhost:7777/homework/inventory-equip-items',
            {equipitemLists: payload.selectedEquipItems})
            .then((res) => {
                alert(res.data)
                dispatch('requestCharacterStatusFromSpring')
            })
    },


    //캐릭터 상태 추가된 부분
    requestCharacterStatusFromSpring ({ commit }) {
        console.log("requestCharacterStatusFromSpring()")

        return axios.post('http://localhost:7777/37th/rpg-game/get-character-status')
            .then((res) => {
                commit(REQUEST_CHARACTER_STATUS_FROM_SPRING, res.data)
            })
    },

    //경험치 교환 추가 부분 ->  dispatch를 이용하면 actions 내부 메소드 가져다가 재호출 가능 -> 원래는 아래 주석코드와 같은 내용
    requestExperienceExchangeFromSpring ({ dispatch }, payload) {
        console.log("requestExperienceExchangeFromSpring()")

        return axios.post('http://localhost:7777/37th/rpg-game/experience/exchange', payload)
            .then((res) => {
                if (res.data === true) {

                    dispatch('requestCharacterStatusFromSpring')
                    alert("경험치 교환에 성공했습니다")
                }
            })
    },

    requestMonsterStatusFromSpring ({ commit }) {
        console.log("몬스터 정보 출력 from 스프링()")

        return axios.get('http://localhost:7777/homework/monster-status')
            .then((res) => {
                commit(REQUEST_MONSTER_STATUS_FROM_SPRING, res.data)
            })
    },

    requestMonsterFromSpring({commit}) {
        console.log("I'm from action - 기본몬스터추가스프링()")

        return axios.get('http://localhost:7777/homework/monster-status')
            .then((res) => {
                commit(REQUEST_MONSTER_FROM_SPRING, res.data)
            })
    },

    //수정필요 플래그 추가 후 수정해보자
    requestManyMonsterAttackFromSpring ({ dispatch }) {
        console.log("몬스터 멀티 공격 실행 from 스프링()")

        return axios.get('http://localhost:7777/homework/multi-monster-attack')
            .then((res) => {
                dispatch('requestMonsterStatusFromSpring')
                if(res.data === true) {
                    dispatch('requestCharacterStatusFromSpring')
                }
            })
    },

    // requestExperienceExchangeFromSpring ({ commit }, payload) {
    //     console.log("requestExperienceExchangeFromSpring()")
    //
    //     return axios.post('http://localhost:7777/37th/rpg-game/experience/exchange', payload)
    //         .then((res) => {
    //             if (res.data == true) {
    //                 axios.post('http://localhost:7777/37th/rpg-game/get-character-status')
    //                     .then((res) => {
    //                         commit(REQUEST_CHARACTER_STATUS_FROM_SPRING, res.data)
    //                     })
    //             }
    //         })
    // },



    //axios는 Promise 기반의 자바스크립트 비동기 처리방식의 라이브러리. 그래서 get 메소드로 요청후 .then()으로 결과값을 받아서 처리를 하는 형식으로 구성
//불러온 데이터는 .then()의 res에 담아서 처리하는 형식
    //commit()은 mutations를 통해 states의 상태값을 변경하라는 메소드

}