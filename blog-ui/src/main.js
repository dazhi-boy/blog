import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import Vant from 'vant'
import 'vant/lib/index.css'

Vue.config.productionTip = false
// Vue.use(axios)
Vue.prototype.$axios = axios
axios.defaults.headers.post['Content-Type'] = 'application/json'

Vue.use(Vant)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
