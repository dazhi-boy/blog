<template>
    <div>
      <div v-if="tvdata.length>0">
        <iframe :src="tv" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe>
      </div>
      <div>
        <ul>
          <li v-for="(item, index) in tvdata" :key="item.id" @click="choice(index)" :class="{ liBackground:changeLeftBackground == index}">
            <h3>{{item.name}}</h3>
            <p>{{item.description}}</p>
          </li>
        </ul>
      </div>
    </div>
</template>

<script>
export default {
  name: 'TutorialDetail',
  data () {
    return {
      tvdata: [],
      active: 1,
      tv: '',
      changeLeftBackground: 0
    }
  },
  mounted: function () {
    this.$axios.get(`/blog/tutorial-tv`)
      .then(resp => {
        this.tvdata = resp.data.data.records
        if (this.tvdata.length > 0) {
          this.tv = this.tvdata[0].tv
        }
        console.log(resp.data.data.records)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      })
  },
  methods: {
    choice (index) {
      this.changeLeftBackground = index
      this.tv = this.tvdata[index].tv
      console.log(index)
    }
  }
}
</script>

<style scoped>
.liBackground {
  background: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#cccccc));
}
</style>
