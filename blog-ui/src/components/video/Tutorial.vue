<template>
    <div>
      <van-tabs  active="active" animated @rendered="onLoad">
        <van-tab v-for="item in themes" :key="item.id" :title="item.name">
          <!-- 轮播图 -->
          <div class="img-banner">
            <van-swipe class="my-swipe" :autoplay="3000">
              <van-swipe-item v-for="(image) in imgList" :key="image.id" @click="picBanner(image.id)">
                <img v-lazy="image.image">
              </van-swipe-item>
            </van-swipe>
          </div>
          <!-- 列表 -->
          <div class="flex-wrap">
            <div class="nowrap" v-for="(tvClass) in tvClazzs" :key="tvClass.id" @click="toDetail(tvClass.id)">
              <van-image :src="tvClass.image" width="100%" height="8rem">
              </van-image>
              <span>{{tvClass.name}}</span>
            </div>
          </div>
        </van-tab>
      </van-tabs>
      <!-- <iframe v-for="item in tvdata" :key="item.id" :src="item.tv" scrolling="no" border="0" frameborder="no" framespacing="0" allowfullscreen="true"> </iframe> -->
    </div>
</template>

<script>
import Vue from 'vue';
import { Lazyload } from 'vant';

Vue.use(Lazyload);

export default {
  name: 'Tutorial',
  data () {
    return {
      themes: [],
      tvClazzs: [],
      imgList: [],
      tab: '1'
    }
  },
  mounted: function () {
    // 获取分类信息
    this.$axios.get(`/blog/theme`)
      .then(resp => {
        this.themes = resp.data.data.records
        console.log(resp.data.data.records)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      });
  },
  methods: {
    onLoad(tab) {
      console.log(tab);
      if(tab==0) tab = 1;
      this.tab = tab;
      // 获取科目列表
      this.$axios.get(`/blog/tv-classification/pid/`+tab)
      .then(resp => {
        this.tvClazzs = resp.data.data
        this.imgList = resp.data.data
        console.log(resp.data.data)
      })
      .catch(function (error) { // 请求失败处理
        console.log(error)
      });
    },
    picBanner(id){
      
    },
    toDetail(tvClassId) {
      this.$router.push({
        name: 'TutorialDetail',
        params: {
          id: tvClassId,
          tab: this.tab
        }
      })
    }
  }
}
</script>

<style scoped>
.img-banner {
  padding: 1vw;
}
.my-swipe .van-swipe-item {
  color: #fff;
  text-align: center;
  height: 12rem;
  background-color: #39a9ed;
}
.my-swipe .van-swipe-item img{
  width: 100%;
  height: 12rem;
}
.flex-wrap{
  display: flex;
  display: -webkit-flex;
  flex-wrap: wrap;
  width: 100vw;
  height: 60vh;
  padding: 1vw;
  overflow-y: auto;
}
.nowrap{
  width: 47vw;
  height: 10rem;
  padding: 1vw;
}
</style>
