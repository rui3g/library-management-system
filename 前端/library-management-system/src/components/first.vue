<template>
  <div class="first">
    <h1 style="text-align: center;margin-top: 3%;">欢迎使用仁爱教材出入库系统</h1>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>系统公告</span>
        <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
      </div>
      <div v-for="o in notice"  class="text item">
        {{o.content}}
      </div>
    </el-card>
    <el-card class="box-card1">
      <div slot="header" class="clearfix1">
        <span>消息通知</span>
        <el-button style="float: right; padding: 3px 0" type="text">更多</el-button>
      </div>
      <div v-for="o in inform" class="text1 item1">
        {{o.content}}
      </div>
    </el-card>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        notice: [{
          content: ''
        }],
        inform: [{
          content: ''
        }]
      }
    },
    methods:{
    },
    mounted() {
      this.$axios({
        method: "post",
        url: "/System/selectSystem"
      }).then(response => {
        console.log(response)
        if (response.data.code == "1") {
          this.notice = response.data.result;
        } else {
          this.$toast('获取参数失败')
        }
      })
      this.$axios({
        method: "post",
        url: "/System/selectInformtion"
      }).then(response => {
        console.log(response)
        if (response.data.code == "1") {
          this.inform = response.data.result;
        } else {
          this.$toast('获取参数失败')
        }
      })
    }
  }

</script>

<style scoped="scoped">
  .first{
   float: left;
   text-align-last: center;
   width: 84%;
   height: 930px;
  }
  .text {
      font-size: 14px;
    }
    .item {
      margin-bottom: 18px;
    }
    .clearfix:before,
    .clearfix:after {
      display: table;
      content: "";
    }
    .clearfix:after {
      clear: both
    }
    .box-card {
      width: 45%;
      margin-top: 5%;
      margin-left: 3%;
      height: 500px;
      float: left;
    }
    .text1 {
        font-size: 14px;
      }
      .item1 {
        margin-bottom: 18px;
      }
      .clearfix1:before,
      .clearfix1:after {
        display: table;
        content: "";
      }
      .clearfix1:after {
        clear: both
      }
      .box-card1 {
        width: 45%;
        margin-top: 5%;
        margin-left: 3%;
        height: 500px;
        float: left;

      }
</style>
