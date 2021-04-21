/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      alias: "/bidding",
      name: "bidding",
      component: () => import("./components/BiddingList")
    },
    {
      path: "/bidding/view/:id",
      name: "bidding-view",
      component: () => import("./components/BiddingView")
    },
    {
      path: "/bidding/add",
      name: "bidding-add",
      component: () => import("./components/BiddingAdd")
    }
  ]
});