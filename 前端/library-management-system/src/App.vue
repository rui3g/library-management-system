<template>
  <!--<div id="app">-->
    <Menu></Menu>
    <!-- <el-row class="tac" v-show="!this.$route.meta.isShow">
     <el-col :span="12">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          router
          :default-active="$router.path"
          >
          <h4 class="logo">教材出入库系统</h4>
          <el-menu-item index="/">
            <i class="el-icon-s-home"></i>
            <span slot="title">首页</span>
          </el-menu-item>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-sell"></i>
              <span>入库管理</span>
            </template>
              <el-menu-item index="/home">教材预定</el-menu-item>
              <el-menu-item index="/enter_storage">入库记录</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-sold-out"></i>
              <span>出库管理</span>
            </template>
             <el-menu-item index="/delivery">出库记录</el-menu-item>
             <el-menu-item index="/inform">费用通知</el-menu-item>
             <el-menu-item index="/accounting">费用核算</el-menu-item>
          </el-submenu>
          <el-menu-item index="/storage">
            <i class="el-icon-s-cooperation"></i>
            <span slot="title">库存管理</span>
          </el-menu-item>
          <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span>基础设置</span>
            </template>
              <el-menu-item index="/customer_reviews">用户审核</el-menu-item>
              <el-menu-item index="/uppassword">个人中心</el-menu-item>
          </el-submenu>
          <el-menu-item index="/" @click="flush()">
            <i class="el-icon-switch-button"></i>
            <span slot="title">退出系统</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
    <el-menu
      :default-active="$router.path"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      v-show="!this.$route.meta.isShow"
      router
      >
      <el-menu-item index="/">处理中心</el-menu-item>
      <el-submenu index="2">
        <template slot="title">我的工作台</template>
        <el-submenu index="2-1">
          <template slot="title">入库管理</template>
          <el-menu-item index="/home">教材预定</el-menu-item>
          <el-menu-item index="/enter_storage">入库记录</el-menu-item>
        </el-submenu>
		    <el-submenu index="2-2">
          <template slot="title">出库管理</template>
          <el-menu-item index="/delivery">出库记录</el-menu-item>
          <el-menu-item index="/inform">费用通知</el-menu-item>
          <el-menu-item index="/accounting">费用核算</el-menu-item>
        </el-submenu>
        <el-menu-item index="/storage">库存管理</el-menu-item>
      </el-submenu>
      <el-menu-item index="/informtion_manage">消息中心</el-menu-item>
      <el-menu-item index="/notice_managerment">公告管理</el-menu-item>
    </el-menu>-->
    <!--<router-view></router-view>-->
  <!--</div>-->
</template>

<script>

import Menu from './components/menu.vue';

export default {
  name:'App',
  components: {
        Menu
      },
  data() {
        return {
          // activeIndex: '1',
          // activeIndex2: '1',
          // type: 0,
          // teacher: true,
          // hdepartment: true,
          // assistant: true,
          // office: true
        }
      },
      methods: {
        // handleSelect(key, keyPath) {
        //   console.log(key, keyPath);
        // },
        // handleOpen(key, keyPath) {
        //   console.log(key, keyPath);
        // },
        // handleClose(key, keyPath) {
        //   console.log(key, keyPath);
        // },
        // flush() {
        //   sessionStorage.removeItem("uid");
        //   sessionStorage.removeItem("custormer");
        //   sessionStorage.removeItem("password");
        //   sessionStorage.removeItem("type");
        //   sessionStorage.removeItem("departmentID")
        // }

      }
}
</script>

<style scoped="scoped">
  /* .el-row {
      margin-bottom: 20px;
      &:last-child {
        margin-bottom: 0;
      }
    }
    .el-col {
      border-radius: 4px;
    }
    .bg-purple-dark {
      background: #99a9bf;
    }
    .bg-purple {
      background: #d3dce6;
    }
    .bg-purple-light {
      background: #e5e9f2;
    }
    .grid-content {
      border-radius: 4px;
      min-height: 70px;
    }
    .row-bg {
      padding: 10px 0;
      background-color: #f9fafc;
    }
    .el-menu-demo{
      min-height: 70px;
      float: left;
      min-width: 84%;
    }
    .el-menu-vertical-demo.el-menu{
      height: 1000px;
      width: 199%;
    }
    .tac{
      float: left;
      width: 16%;
    }
    .logo{
      color: #fff;
      text-align: center;
    } */

</style>
