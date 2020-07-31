import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'log',
      component: () => import('@/views/log')
    },
    {
      path: '/reg',
      component: () => import('@/views/reg'),
      hidden: true
    },
    {
      path: '/editUser',
      component: () => import('@/views/UserMsgEdit'),
      hidden: true
    },
    {
      path: '/RoleEdit',
      component: () => import('@/views/RoleEdit'),
      hidden: true
    },
    {
      path: '/PermisEdit',
      component: () => import('@/views/PermisEdit'),
      hidden: true
    },
    {
      path: '/RolePermisAdd',
      component: () => import('@/views/RolePermisAdd'),
      hidden: true
    },
    {
      path: '/main',
      component: () => import('@/views/main'),
      hidden: true,
      children: [
        {
          path: '/demo1',
          name: 'Demo1',
          component: () => import('@/views/demo1')
        },
        {
          path: '/demo2',
          name: 'Demo2',
          component: () => import('@/views/demo2')
        },
        {
          path: '/demo3',
          name: 'Demo3',
          component: () => import('@/views/demo3')
        }
      ]
    }
  ]
})
