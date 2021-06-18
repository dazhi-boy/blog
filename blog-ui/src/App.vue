<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <i-Bar></i-Bar>
    <div class="_router">
      <router-view/>
    </div>
    <i-Bottom></i-Bottom>
  </div>
</template>

<script>
import Bottom from '@/components/common/Bottom'
import Bar from '@/components/common/Bar'
export default {
  name: 'App',
  components: {
    'i-Bottom': Bottom,
    'i-Bar': Bar
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}

page,text,view,navigator,swiper,swiper-item,image,h1,h2,h3,h4,h5,h6{
  /*设置组件全局边距*/
  margin: 0px;
  padding: 0px;
  /*
  * 指定元素的宽或高包含padding和border，不包含mmargin。
  * 如果不设置默认为content-box，元素的宽或高不包含padding和border
  */
  box-sizing: border-box;
}

._router {
  height: 88vh;
  width: 100vw;
  overflow: hidden;
}
</style>
