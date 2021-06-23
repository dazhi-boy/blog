<template>
  <div>
    <!-- 视频 -->
    <div>
      <iframe :src="tv" class="tv_iframe"> </iframe>
    </div>
    <!-- 列表 -->
    <h4>其他内容</h4>
    <div class="tv_list">
      <ul>
        <li v-for="(item, index) in tvdata" :key="item.id" @click="choice(index)" :class="{ liBackground:changeLeftBackground == index}">
          <h5>{{item.name}}</h5>
        </li>
      </ul>
    </div>
    <!-- 相关推荐 -->
    <h4>相关推荐</h4>
    <!-- 列表 -->
    <div class="flex-wrap">
      <div class="nowrap" v-for="(tvClass) in imgList" :key="tvClass.id" @click="toDetail(tvClass.id)">
        <van-image :src="tvClass.image" width="100%" height="8rem">
        </van-image>
        <span>{{tvClass.name}}</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TutorialDetail',
  data () {
    return {
      id: '1',
      tvdata: [],
      imgList: [],
      tv: '',
      changeLeftBackground: 0
    }
  },
  mounted: function () {
    this.id = this.$route.params.id
    const tab = this.$route.params.tab
    const _id = this.id
    // console.log(_id)
    this.$axios.get(`/blog/tutorial-tv/pid/`+_id)
      .then(resp => {
        this.tvdata = resp.data.data
        this.tv = resp.data.data[0].tv
        console.log(resp.data.data)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      });

    this.$axios.get(`/blog/tv-classification/pid/`+tab)
      .then(resp => {
        this.imgList = resp.data.data
        console.log(resp.data.data)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      });
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
  background: lightsteelblue;
}
.tv_iframe {
  width: 98vw;
  height: 25vh;
  padding: 1vw;
  border: 0;
}
h4 {
  border-left: 3px solid brown;
  margin: 0;
  margin-left: 1vw;
  padding-left: 1vw;
  text-align: left;
}
.tv_list {
  padding: 1vw;
  text-align: left;
  height: 15vh;
  overflow-y: auto;
}
.flex-wrap{
  display: flex;
  display: -webkit-flex;
  flex-wrap: wrap;
  width: 100%;
  height: 40vh;
  padding: 1vw;
  overflow-y: auto;
}
.nowrap{
  width: 47vw;
  height: 10rem;
  padding: 1vw;
}
</style>
