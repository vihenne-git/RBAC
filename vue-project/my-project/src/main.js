// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios' // 修改原型链，在main.js中引入axios
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.prototype.$axios = axios
axios.defaults.baseURL = '/api'
axios.defaults.headers.post['Content-Type'] = 'application/json'
Vue.config.productionTip = false
Vue.use(ElementUI)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  data: function () {
    return {
      id: 1,
      nickname: '昵称',
      email: '邮箱',
      pswd: '密码',
      create_time: '2020/01/02',
      last_login_time: '2020/01/02'
    }
  },
  components: { App },
  template: '<App/>'
})
