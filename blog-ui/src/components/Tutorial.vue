<template>
    <div>
      <van-dropdown-menu>
        <van-dropdown-item v-model="value1" :options="option1" />
        <van-dropdown-item v-model="value2" :options="option2" />
      </van-dropdown-menu>
      <iframe v-for="item in tvdata" :key="item.id" :src="item.tv" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>
    </div>
</template>

<script>
export default {
  name: 'Tutorial',
  data () {
    return {
      tvdata: [],
      value1: 0,
      value2: 'a',
      option1: [
        { text: '全部商品', value: 0 },
        { text: '新款商品', value: 1 },
        { text: '活动商品', value: 2 }
      ],
      option2: [
        { text: '默认排序', value: 'a' },
        { text: '好评排序', value: 'b' },
        { text: '销量排序', value: 'c' }
      ]
    }
  },
  mounted: function () {
    this.$axios.get(`/blog/tv-classification`)
      .then(resp => {
        this.tvdata = resp.data.data.records
        console.log(resp.data.data.records)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      })
  }
}
</script>

<style scoped>

</style>
