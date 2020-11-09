import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Add from '@/components/Add'
import Me from '@/components/Me'
import List from '@/components/List'
import Detail from '@/components/Detail'
import Tutorial from '@/components/Tutorial'
import TutorialDetail from '@/components/TutorialDetail'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/add',
      name: 'Add',
      component: Add
    },
    {
      path: '/me',
      name: 'Me',
      component: Me
    },
    {
      path: '/list',
      name: 'List',
      component: List
    },
    {
      path: '/tutorial',
      name: 'Tutorial',
      component: Tutorial
    },
    {
      path: '/detail',
      name: 'Detail',
      component: Detail
    },
    {
      path: '/tutorialDetail',
      name: 'TutorialDetail',
      component: TutorialDetail
    }
  ]
})
