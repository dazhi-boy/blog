import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import Vant from 'vant'
import 'vant/lib/index.css'
import global_ from './Global'
import store from './store'

Vue.config.productionTip = false
Vue.prototype.GLOBAL = global_
// Vue.use(axios)
Vue.prototype.$axios = axios
axios.defaults.headers.post['Content-Type'] = 'application/json'

Vue.use(Vant)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
