<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div>
      <swiper :options="swiperOption">
          <swiper-slide class="swiper-slide" v-for="(item,index) in slide" :key="index">
            <img :src="item.image"/>
                slide{{item}}
          </swiper-slide>
      </swiper>
    </div>
    <ul>
      <li>
        <a
          href="https://vuejs.org"
          target="_blank"
        >
          Core Docs
        </a>
      </li>
      <li>
        <a
          href="https://forum.vuejs.org"
          target="_blank"
        >
          Forum
        </a>
      </li>
      <li>
        <a
          href="https://chat.vuejs.org"
          target="_blank"
        >
          Community Chat
        </a>
      </li>
    </ul>
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
      msg: 'Welcome to Your Vue.js App',
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
      .then(res => {
        console.log(res.data)
        this.activity = res.data.data.records
        this.slide = res.data.data.records
      })
      .catch(err => {
        console.log(err.response)
      })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
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

.swiper-slide{
  height: 450px;
  background:cadetblue;
  font-size: 50px;
  text-align: center;
  line-height: 450px;
}
</style>
