<template>
  <div>
    <div v-if="chackIsLogin">
      <van-row>
        <van-col span="16">
          <h4>{{GLOBAL.localStorage.username}}</h4>
        </van-col>
        <van-col span="8">
          <van-image width="100" height="100" :src="this.GLOBAL.localStorage.image" />
        </van-col>
      </van-row>
    </div>

    <div v-else>
      <van-tabs v-model="active">
        <van-tab title="登录">
          <van-form @submit="onLogin">
            <van-field
              v-model="username"
              name="用户名"
              label="用户名"
              placeholder="用户名"
              :rules="[{ required: true, message: '请填写用户名' }]"
            />
            <van-field
              v-model="password"
              type="password"
              name="密码"
              label="密码"
              placeholder="密码"
              :rules="[{ required: true, message: '请填写密码' }]"
            />
            <div style="margin: 16px;">
              <van-button round block type="info" native-type="submit">
                登录
              </van-button>
            </div>
          </van-form>
        </van-tab>
        <van-tab title="注册">
          <van-form @submit="onSubmit">
            <van-field
              v-model="username"
              name="username"
              label="用户名"
              placeholder="用户名"
              :rules="[{ required: true, message: '请填写用户名' }]"
            />
            <van-field
              v-model="password"
              type="password"
              name="password"
              label="密码"
              placeholder="密码"
              :rules="[{ required: true, message: '请填写密码' }]"
            />
            <van-field
              v-model="re_password"
              type="password"
              name="re_password"
              label="再次输入密码"
              placeholder="再次输入密码"
              :rules="[{ required: true, message: '请再次输入密码' }]"
            />
            <div style="margin: 16px;">
              <van-button round block type="info" native-type="submit">
                注册
              </van-button>
            </div>
          </van-form>
        </van-tab>
      </van-tabs>
    </div>
  </div>
</template>
<script>
export default {
  name: 'Me',
  data () {
    return {
      active: 0,
      username: '',
      password: '',
      re_password: '',
      isLogin: false
    }
  },
  computed: {
    chackIsLogin () {
      return window.sessionStorage.getItem('isLogin')
    }
  },
  mounted: function () {
    console.log(window.sessionStorage.getItem('isLogin'))

    this.isLogin = window.sessionStorage.getItem('isLogin')
  },
  methods: {
    onSubmit (values) {
      console.log('submit', values)
    },
    onLogin (values) {
      console.log('submit', values)
      if (this.username === this.password) {
        this.GLOBAL.localStorage.username = this.username
        this.GLOBAL.localStorage.isLogin = true
        window.sessionStorage.setItem('username', this.username)
        window.sessionStorage.setItem('isLogin', true)
        this.isLogin = true
        // this.$router.push({
        //   name: 'Me'
        // })
        console.log(window.sessionStorage.getItem('username'))
      }
    }
  }
}
</script>
<style>

</style>
