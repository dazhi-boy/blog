<template>
  <div class="hello">
    <van-cell title="北京" icon="location-o" />
    <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
      <van-swipe-item v-for="(item, index) in slide" :key="index">
        <img class="img" :src="item.image" />
      </van-swipe-item>
    </van-swipe>
    <!-- <van-button type="primary">主要按钮</van-button> -->

    <van-grid :column-num="2">
      <van-grid-item
        v-for="item in attractions"
        :key="item.id"
        :text="item.name"
      >
      <van-image :src="item.image" />
      <van-field v-text="item.name" />
      <van-field v-text="item.description" />
      </van-grid-item>
    </van-grid>

    <van-tabbar v-model="active">
      <van-tabbar-item to="/" icon="home-o">首页</van-tabbar-item>
      <van-tabbar-item to="/test" icon="add-o">添加</van-tabbar-item>
      <van-tabbar-item to="/" icon="friends-o">我的</van-tabbar-item>
    </van-tabbar>
  </div>
</template>
<script>
import { swiper, swiperSlide } from 'vue-awesome-swiper'
import 'swiper/dist/css/swiper.css'
export default {
  name: 'HelloWorld',
  components: {
    swiper,
    swiperSlide
  },
  data () {
    return {
      active: 0,
      msg: 'Welcome to Your Vue.js App zjg',
      attractions: [],
      slide: [],
      swiperOption: {
        centeredSlides: true,
        loop: true,
        initialSlide: 1,
        spaceBetween: 15,
        on: {
          click: function () {
            // const realIndex = this.realIndex;
          }
        }
      }
    }
  },
  mounted: function () {
    var _this = this
    this.$axios.all([
      this.$axios.get('/activity'),
      this.$axios.get('/attractions')
    ])
      .then(this.$axios.spread(function (activityResp, attractionsResp) {
        // 上面两个请求都完成后，才执行这个回调方法
        _this.slide = activityResp.data.data.records
        _this.attractions = attractionsResp.data.data.records
        console.log('User', activityResp.data.data.records)
        console.log('Repositories', attractionsResp.data)
      }))
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.swiper-slide {
  height: 450px;
  background: cadetblue;
  font-size: 50px;
  text-align: center;
  line-height: 450px;
}

.my-swipe .van-swipe-item {
  color: #fff;
  font-size: 20px;
  line-height: 150px;
  text-align: center;
  background-color: #39a9ed;
}
.my-swipe .img {
  width: auto;
  height: 150px;
}
</style>
