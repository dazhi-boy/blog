<template>
  <van-tabbar v-model="active">
    <van-tabbar-item to="/" icon="home-o">首页</van-tabbar-item>
    <van-tabbar-item to="/tutorial" icon="tv-o">视频</van-tabbar-item>
    <van-tabbar-item to="/add" icon="add-o">添加</van-tabbar-item>
    <van-tabbar-item to="/me" icon="friends-o">我的</van-tabbar-item>
  </van-tabbar>
</template>
<script>
export default {
  name: 'Bottom',
  data () {
    return {
      active: 0
    }
  },
  mounted: function () {}
}
</script>
<style>

</style>
