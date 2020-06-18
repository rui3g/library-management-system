<template>
  <div class="dofir">
  <el-card class="box-card">
      <h1 style="text-align: center;margin-top: 10%;">欢迎使用仁爱学院教材出入库管理系统</h1>
      <div class="in">
        <div class="first">
          <span class="one">账号：</span>
          <el-input v-model="customer" placeholder="请输入账号" clearable></el-input><br />
        </div>
        <div class="second">
          <span class="two">密码：</span>
          <el-input v-model="password" placeholder="请输入密码" show-password></el-input>
        </div>
        <div class="third">
          <span class="two">验证码：</span>
          <el-input v-model="yzm" placeholder="请输入验证码" clearable></el-input>
          <el-button type="primary" @click="createCode()">{{checkCode}}</el-button>
        </div>
        <div class="btn">
          <el-row>
            <el-button type="primary" @click="login()">登录</el-button>
            <el-button type="primary" @click="goregister()">注册</el-button>
          </el-row>
        </div>
      </div>
  </el-card>
  </div>

</template>

<script>
  export default {
    name: 'login',
    data() {
      return {
        customer: '',
        password: '',
        yzm: '',
        checkCode: ''
      }
    },
    methods: {
      goregister () {
        this.$router.push({'name': 'register'})
      },
      login() {
        if (this.yzm !== this.checkCode) {
          this.$alert("验证码错误")
        } else {
          this.$axios({
            method: "post",
            url: "/lc/login",
            data:{
              customer: this.customer,
              password: this.password}
            }).then(response => {
              if (response.data.code == 1) {
                /* this.$alert(response.data.desc) */
                sessionStorage.setItem('uid', response.data.result.uid)
                sessionStorage.setItem('customer', response.data.result.customer)
                sessionStorage.setItem('password', response.data.result.password)
                sessionStorage.setItem('type', response.data.result.type)
                sessionStorage.setItem('departmentID', response.data.result.departmentID)
                /* this.$alert(response.data.result.type); */
                if(response.data.result.status==1){
                  this.$router.push({
                    'name': 'first'
                  })
                  this.$router.go(0);
                }else{
                  this.$alert("请等待管理员分配权限之后再登陆。")
                }
              } else {
               this.$alert(response.data.desc)
              }
            })

        }

      },
      // 图片验证码
      createCode() {
        // 先清空验证码的输入
        this.code = ''
        this.checkCode = ''
        this.picLyanzhengma = ''
        // 验证码的长度
        var codeLength = 4
        // 随机数
        var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
          'm', 'm', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        for (var i = 0; i < codeLength; i++) {
          // 取得随机数的索引（0~35）
          var index = Math.floor(Math.random() * 36)
          // 根据索引取得随机数加到code上
          this.code += random[index]
        }
        // 把code值赋给验证码
        this.checkCode = this.code
      }
    }
  }
</script>

<style scoped="scoped">


  .box-card {
    height: 760px;
    background-image: url(../assets/images/bg2.jpg);
  }

  .el-input {
    width: 25%;
  }

  .in {
    margin-top: 5%;
    margin-left: 40%;
  }

  .second {
    margin-top: 2%;
  }

  .btn {
    margin-top: 3%;
    margin-left: 6%;
  }

  .el-button+.el-button {
    margin-left: 8%;
  }

  .third {
    margin-top: 2%;
    margin-left: -2%;
  }
</style>
