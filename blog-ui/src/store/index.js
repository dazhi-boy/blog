import Vue from 'vue'
import Vuex from 'vuex'
import VuexPersistence from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    username: 'hahahaha',
    isLongin: false
  },
  plugins: [VuexPersistence({
    key: 'vuex',
    storage: window.sessionStorage
  })]
})
