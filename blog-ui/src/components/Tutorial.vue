<template>
    <div>
      <iframe v-for="item in tvdata" :key="item.id" :src="item.tv" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>
    </div>
</template>

<script>
export default {
  name: 'Tutorial',
  data () {
    return {
      tvdata: []
    }
  },
  mounted: function () {
    this.$axios.get(`/blog/tutorial-tv`)
      .then(resp => {
        this.tvdata = resp.data.data.records
        // console.log(resp.data.data.records)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      })
  }
}
</script>

<style scoped>

</style>
