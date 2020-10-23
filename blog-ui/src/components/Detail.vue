<template>
    <div>
      <h1>{{detail.name}}</h1>
      <van-image width="100" height="100" :src="detail.image" />
      <p>{{detail.description}}</p>
      <van-list v-for="item in detail.details"
      :key="item.id">
      <h2>{{item.name}}</h2>
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
    // console.log(id)
    this.$axios.get(`/blog/${this.$route.params.target}/${this.$route.params.id}/info`)
      .then(resp => {
        this.detail = resp.data.data
        // console.log(resp.data.data)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      })
  }
}
</script>

<style scoped>

</style>
