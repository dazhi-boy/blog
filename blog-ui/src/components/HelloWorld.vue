<template>
  <div class="hello">
    <!-- 当前位置和搜索框 -->
    <van-row>
      <van-col span="6">
        <van-cell title="北京" icon="location-o" />
      </van-col>
      <van-col span="18">
        <form action="/">
          <van-search
            v-model="value"
            show-action
            placeholder="请输入搜索关键词"
            @search="onSearch"
            @cancel="onCancel"
          />
        </form>
      </van-col>
    </van-row>
    <!-- 热门活动和轮播图 -->
    <div>
      <van-row>
        <van-col span="6">
          <span>热门活动</span>
        </van-col>
        <van-col span="6" offset="12">
          <van-cell title="更多" is-link @click="getList('activity')" />
        </van-col>
      </van-row>
      <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
        <van-swipe-item v-for="(item, index) in slide" :key="index" @click="detail('activity',item.id)">
          <img class="img" :src="item.image"/>
        </van-swipe-item>
      </van-swipe>
    </div>
    <!-- 攻略 -->
    <van-row>
      <van-col span="6">
        <span>溜达攻略</span>
      </van-col>
      <van-col span="6" offset="12">
        <van-cell title="更多" is-link @click="getList('attractions')" />
      </van-col>
    </van-row>
    <van-grid :column-num="2">
      <van-grid-item
        v-for="item in attractions"
        :key="item.id"
        :text="item.name"
        @click="detail('attractions',item.id)"
      >
      <van-image :src="item.image" />
      <van-field v-text="item.name" />
      <van-field v-text="item.description" />
      </van-grid-item>
    </van-grid>
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
      value: '',
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
      this.$axios.get('/blog/activity'),
      this.$axios.get('/blog/attractions')
    ])
      .then(this.$axios.spread(function (activityResp, attractionsResp) {
        // 上面两个请求都完成后，才执行这个回调方法
        _this.slide = activityResp.data.data.records
        _this.attractions = attractionsResp.data.data.records
        // console.log('User', activityResp.data.data.records)
        // console.log('Repositories', attractionsResp.data)
      }))
  },
  methods: {
    onSearch (val) {
      console.log(val)
    },
    onCancel () {
      console.log('取消')
    },
    getList (target) {
      this.$router.push({
        name: 'List',
        query: {
          target: target
        }
      })
    },
    detail (target, id) {
      this.$router.push({
        name: 'Detail',
        params: {
          target: target,
          id: id
        }
      })
    }
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
.search-field {
  border-bottom: 1px solid #000;
}
</style>
