<template>
  <div>
    test.vue

    <van-tabbar v-model="active">
      <van-tabbar-item to="/" icon="home-o">首页</van-tabbar-item>
      <van-tabbar-item to="/test" icon="add-o">添加</van-tabbar-item>
      <van-tabbar-item to="/" icon="friends-o">我的</van-tabbar-item>
    </van-tabbar>
  </div>
</template>
<script>
export default {
  name: 'test',
  data () {
    return {
      active: 1
    }
  },
  mounted: function () {}
}
</script>
<style>

</style>
