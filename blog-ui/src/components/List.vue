<template>
    <div>
      这个是活动详情
      <van-card
        v-for="item in mydata"
        :key="item.id"
        :title="item.name"
        :desc="item.description"
        :thumb="item.image"
        @click="detail(item.id)"
      />
    </div>
</template>

<script>
export default {
  name: 'List',
  data () {
    return {
      mydata: []
    }
  },
  mounted: function () {
    this.$axios.get('/activity')
      .then(resp => {
        this.mydata = resp.data.data.records
        console.log(resp.data.data.records)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      })
  },
  methods: {
    detail (id) {
      console.log(id)
      this.$axios.get(`/activity/1/info`)
        .then(resp => {
          // this.mydata = resp.data.data.records
          console.log(resp.data.data.records)
        })
        .catch(function (error) { // 请求失败处理
          console.log(error)
        })
    }
  }
}
</script>

<style scoped>

</style>
