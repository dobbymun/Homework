<template>
  <div>
    <h3>상점 (Local Component)</h3>

    <label>
      <input type="checkbox" v-model="shopView" v-on:click="shuffleShopList()">
      판매 목록
    </label>
    <button v-on:click="buyItem()">구매 확정</button>
    <table border="1" v-if="shopView">
      <tr>
        <th align="center" width="40">번호</th>
        <th align="center" width="120">아이템명</th>
        <th align="center" width="160">가격</th>
        <th align="center" width="320">아이템 설명</th>
        <th align="center" width="40">구매</th>
      </tr>
      <tr v-for="(item, index) in shopList" :key="index">
        <th align="center" width="40">{{ index }}</th>
        <th align="center" width="120">{{ item.name }}</th>
        <th align="center" width="160">{{ item.price }}</th>
        <th align="center" width="320">{{ item.description }}</th>
        <th align="center" width="40">
          <label>
            <input type="checkbox" v-model="shopListValue" :value="index">
          </label>
        </th>
      </tr>
    </table>
  </div>
</template>

<script>
import {mapActions} from "vuex";
export default {
  name: "MarketManager",
  data () {
    return {
      shopView: false,
      shopList: [],
      shopListValue: [],
    }
  },
  methods: {
    ...mapActions([
      'requestRandomGameItem',
      'requestBuyItem'
    ]),
    async shuffleShopList() {                                   // await가 사용되는 매소드명 앞에 async 붙이기
      if (!this.shopView) {
        this.shopListValue = []
        await this.requestRandomGameItem()                       // await는 앞서 계산되어야 할 값이 있는 경우 붙이기
        this.shopList = this.$store.state.randomShopItem
      }
    },
    async buyItem () {
      let calculatedPrice = this.calcBuyList()
      let selectedItems = this.checkSelectedItemList()
      let payload = { calculatedPrice, selectedItems }  // {}로 묶으면 객체로 만들어줌
      await this.requestBuyItem(payload)                // payload 를 객체로 생성해서 인자로 넣어주기
    },
    checkSelectedItemList () {                          // 사용자가 구매 선택한 아이템리스트
      let tmpList = []
      for (let i = 0; i < this.shopListValue.length; i++) {
        tmpList.push(this.shopList[this.shopListValue[i]])
      }
      console.log(tmpList)
      return tmpList
    },
    calcBuyList () {                              // 사실 calBuyList는 자바에서 계산해도 됨 -> 두개의 인자를 묶어서 보내는 법에 대한 예시용
      let calculatedPrice = 0
      for (let i = 0; i < this.shopListValue.length; i++) {
        for (let j = 0; j < this.shopList.length; j++) {
          if (this.shopListValue[i] === j) {
            calculatedPrice += this.shopList[j].price
            break
          }
        }
      }
      console.log(calculatedPrice)
      return calculatedPrice
    },
  }
}
</script>

<style scoped>
</style>