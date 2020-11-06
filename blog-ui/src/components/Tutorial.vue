<template>
    <div>
      <van-tabs>
        <van-tab v-for="item in tvdata" :key="item.id" :title="item.name">
          <van-grid :column-num="2">
            <van-grid-item
              v-for="one in item.child"
              :key="one.id"
              :text="one.name"
              @click="detail('attractions',one.id)"
            >
              <van-image :src="one.image" />
              <van-field v-text="one.name" />
              <van-field v-text="one.description" />
            </van-grid-item>
          </van-grid>
        </van-tab>
      </van-tabs>
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
    this.$axios.get(`/blog/tv-classification/1/list`)
      .then(resp => {
        this.tvdata = resp.data.data
        console.log(resp.data.data)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      })
  },
  methods: {
    detail (target, id) {
      this.$router.push({
        name: 'Detail',
        params: {
          target: target,
          id: id
        }
      })
    }
  }
}
</script>

<style scoped>
.tv_type {
  background: red;
  margin: 20px;
}
</style>
