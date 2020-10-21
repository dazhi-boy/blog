<template>
    <div>
      <p>{{detail.name}}</p>
      <van-image width="100" height="100" :src="detail.image" />
      <p>{{detail.description}}</p>
      <van-list v-for="item in detail.details"
      :key="item.id">
      <p>{{item.name}}</p>
      <van-image width="100" height="100" :src="item.image" />
      <p>{{item.description}}</p>
      </van-list>
    </div>
</template>

<script>
export default {
  name: 'Detail',
  data () {
    return {
      detail: {}
    }
  },
  mounted: function () {
    this.$axios.get(`/activity/1/info`)
      .then(resp => {
        this.detail = resp.data.data
        console.log(resp.data.data)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      })
  }
}
</script>

<style scoped>

</style>
