import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path:'/bay',
    name:'Bay',
    component:()=>import('../views/Bay.vue')
  },
  {
    path:'/finder',
    name:'Finder',
    component:()=>import('../views/Finder.vue')
  },
  {
    path:'/map',
    name:'Map',
    component:()=>import('../views/Map.vue')
  },
  {
    path:'/admin',
    name:'admin',
    component:()=>import('../views/admin.vue')
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router
