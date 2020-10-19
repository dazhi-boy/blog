<template>
  <div class="hello">
    <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
      <van-swipe-item v-for="(item, index) in slide" :key="index">
        <img class="img" :src="item.image" />
      </van-swipe-item>
    </van-swipe>
    <!-- <van-button type="primary">主要按钮</van-button> -->

    <van-grid :column-num="3">
      <van-grid-item
        v-for="value in 6"
        :key="value"
        icon="photo-o"
        text="文字"
      />
    </van-grid>

    <van-tabbar v-model="active">
      <van-tabbar-item to="/" icon="home-o">标签</van-tabbar-item>
      <van-tabbar-item to="/test" icon="search">标签</van-tabbar-item>
      <van-tabbar-item to="/" icon="friends-o">标签</van-tabbar-item>
      <van-tabbar-item to="/test" icon="setting-o">标签</van-tabbar-item>
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
      activity: [],
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
  // components: {
  //   swiper,
  //   swiperSlide
  // },
  mounted: function () {
    this.$axios
      .get('/blog/activity')
      .then((res) => {
        console.log(res.data)
        this.activity = res.data.data.records
        this.slide = res.data.data.records
      })
      .catch((err) => {
        console.log(err.response)
      })
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
