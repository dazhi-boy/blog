<template>
    <div>
      <div v-if="tvdata.length>0">
        <iframe :src="tvdata[0].tv" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>
      </div>
      <div>
        <van-steps direction="vertical" :active="active">
          <van-step v-for="item in tvdata" :key="item.id" @click="choice()">
            <h3>{{item.name}}</h3>
            <p>{{item.description}}</p>
          </van-step>
        </van-steps>
      </div>
    </div>
</template>

<script>
export default {
  name: 'TutorialDetail',
  data () {
    return {
      tvdata: [],
      active: 1
    }
  },
  mounted: function () {
    this.$axios.get(`/blog/tutorial-tv`)
      .then(resp => {
        this.tvdata = resp.data.data.records
        console.log(resp.data.data.records)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      })
  },
  methods: {
    choice () {
      console.log('sfsafds')
    }
  }
}
</script>

<style scoped>

</style>
