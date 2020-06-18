import Vue from 'vue'
import Router from 'vue-router'
import home from '@/components/home'
import first from '@/components/first'
import enter_storage from '@/components/enter_storage'
import delivery from '@/components/delivery'
import storage from '@/components/storage'
import inform from '@/components/inform'
import take_out from '@/components/take_out'
import accounting from '@/components/accounting'
import take_in from '@/components/take_in'
import take_acounting from '@/components/take_acounting'
import notice_managerment from '@/components/notice_managerment'
import informtion_manage from '@/components/informtion_manage'
import customer_reviews from '@/components/customer_reviews'
import menu from '@/components/menu'
import register from '@/components/register'
import uppassword from '@/components/uppassword'
import login from '@/components/login'


Vue.use(Router)

export default new Router({
  routes: [{
      path: '/home',
      name: 'home',
      component: home
    },
    {
      path: '/first',
      name: 'first',
      component: first
    },
    {
      path: '/enter_storage',
      name: 'enter_storage',
      component: enter_storage
    },
    {
      path: '/delivery',
      name: 'delivery',
      component: delivery
    },
    {
      path: '/storage',
      name: 'storage',
      component: storage
    },
    {
      path: '/inform',
      name: 'inform',
      component: inform
    },
    {
      path: '/take_out',
      name: 'take_out',
      component: take_out,
      meta: {
        isShow: true
      }
    },
    {
      path: '/accounting',
      name: 'accounting',
      component: accounting
    },
    {
      path: '/take_in',
      name: 'take_in',
      component: take_in,
      meta: {
        isShow: true
      }
    },
    {
      path: '/take_acounting',
      name: 'take_acounting',
      component: take_acounting,
      meta: {
        isShow: true
      }
    },
    {
      path: '/notice_managerment',
      name: 'notice_managerment',
      component: notice_managerment,
    },
    {
      path: '/informtion_manage',
      name: 'informtion_manage',
      component: informtion_manage,
    },
    {
      path: '/customer_reviews',
      name: 'customer_reviews',
      component: customer_reviews,
    },
    {
      path: '/',
      name: 'login',
      component: login,
      meta: {
        isShow: true
      }
    },
    {
      path: '/register',
      name: 'register',
      component: register,
      meta: {
        isShow: true
      }
    },
    {
      path: '/menu',
      name: 'menu',
      component: menu
    },
    {
      path: '/uppassword',
      name: 'uppassword',
      component: uppassword
    }
  ]
})
