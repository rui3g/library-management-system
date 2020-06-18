<template>
  <div id="app">
    <el-row class="tac" v-show="!this.$route.meta.isShow">
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
          <el-menu-item index="/first">
            <i class="el-icon-s-home"></i>
            <span slot="title">首页</span>
          </el-menu-item>
          <el-submenu index="1" v-show="manage">
            <template slot="title">
              <i class="el-icon-sell"></i>
              <span>入库管理</span>
            </template>
              <el-menu-item index="/home" v-show="reserve">教材预定</el-menu-item>
              <el-menu-item index="/enter_storage" >入库记录</el-menu-item>
          </el-submenu>
          <el-submenu index="2" v-show="outlay">
            <template slot="title">
              <i class="el-icon-sold-out"></i>
              <span>出库管理</span>
            </template>
             <el-menu-item index="/delivery">出库记录</el-menu-item>
             <el-menu-item index="/inform">费用通知</el-menu-item>
             <el-menu-item index="/accounting">费用核算</el-menu-item>
          </el-submenu>
          <el-menu-item index="/storage" v-show="diver">
            <i class="el-icon-s-cooperation"></i>
            <span slot="title">库存管理</span>
          </el-menu-item>
          <el-submenu index="4">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span>基础设置</span>
            </template>
              <el-menu-item index="/customer_reviews" v-show="pass">用户审核</el-menu-item>
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
      <el-menu-item index="/first">处理中心</el-menu-item>
      <el-submenu index="2"  v-show="work">
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
      <el-menu-item index="/informtion_manage" v-show="inform">消息中心</el-menu-item>
      <el-menu-item index="/notice_managerment" v-show="notice">公告管理</el-menu-item>
    </el-menu>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name:'App',
  data() {
        return {
          activeIndex: '1',
          activeIndex2: '1',
          type: 0,
          work: true,
          manage: true,
          outlay: true,
          diver: true,
          pass: true,
          reserve: true,
          inform: true,
          notice: true
        }
      },
      methods: {
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        },
        handleOpen(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
          console.log(key, keyPath);
        },
        flush() {
          sessionStorage.removeItem("uid");
          sessionStorage.removeItem("customer");
          sessionStorage.removeItem("password");
          sessionStorage.removeItem("type");
          sessionStorage.removeItem("departmentID");
          this.$router.go(0);
        }

      },
      watch:{
        type(val){
          //this.type = sessionStorage.getItem("type");
          //this.$alert(this.type);
          if (val == 1) {
            this.manage = false;
            this.outlay = false;
            this.diver = false;
            this.pass = false;
            this.work= false;
            this.inform = false;
            this.notice = false;
          } else if (val == 2) {
            this.pass = false;
            this.inform = false;
            this.notice = false;
            this.reserve = false;
          } else if (val == 3) {
            this.reserve= false;
            this.outlay = false;
            this.diver = false;
            this.pass = false;
            this.work= false;
            this.inform = false;
            this.notice = false;
          } else if (val == 4) {
             this.notice = false;
             this.pass = false;
          }else if(val == 5){
            this.manage = true;
            this.outlay = true;
            this.diver = true;
            this.pass = true;
            this.work= true;
            this.inform = true;
            this.notice = true;
          }
        }
      },
      created: function() {
        /* this.$router.go(0); */
        this.type = sessionStorage.getItem("type");
        //this.$alert(this.type);
        /* if (this.type == 1) {
          this.hdepartment = false;
          this.assistant = false;
          this.office = false;
        } else if (this.type == 2) {
          this.teacher = false;
          this.assistant = false;
          this.office = false;
        } else if (this.type == 3) {
          this.teacher = false;
          this.hdepartment = false;
          this.office = false;
        } else if (this.type == 4) {
          this.teacher = false;
          this.hdepartment = false;
          this.assistant = false;
        } */
      }



}
</script>

<style scoped="scoped">
  .el-row {
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
    }

</style>
