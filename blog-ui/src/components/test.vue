<template>
  <div>
    test.vue

    <van-tabbar v-model="active">
      <van-tabbar-item to="/" icon="home-o">标签</van-tabbar-item>
      <van-tabbar-item to="/test" icon="search">标签</van-tabbar-item>
      <van-tabbar-item to="/" icon="friends-o">标签</van-tabbar-item>
      <van-tabbar-item to="/test" icon="setting-o">标签</van-tabbar-item>
    </van-tabbar>
  </div>
</template>
<script>
export default {
  name: "test",
  data() {
    return {
      active: 1,
    };
  },
  mounted: function () {},
};
</script>
<style>
</style>