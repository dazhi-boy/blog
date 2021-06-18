<template>
  <van-nav-bar title="标题" left-text="返回" left-arrow>
      <van-icon name="search" slot="right" />
  </van-nav-bar>
</template>
<script>
export default {
  name: 'Bar',
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