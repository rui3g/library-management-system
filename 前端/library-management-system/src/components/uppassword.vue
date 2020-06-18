<template>
  <div>
    <br />
    <h1 class="top">修改密码</h1>

    <div class="second">
      <span class="two">账号：</span>
      <el-input v-model="customer"  :disabled="true"></el-input>

      <br />
      <br />

      <span class="three">旧密码：</span>
      <el-input v-model="oldpassword" placeholder="请输入原密码" show-password></el-input>

      <br />
      <br />

      <span class="four">新密码：</span>
      <el-input v-model="newpassword" placeholder="请输入新密码" show-password></el-input>

      <br />
      <br />

      <span class="five">确认密码：</span>
      <el-input v-model="newpasswords" placeholder="请确认新密码" show-password></el-input>

      <br />
      <br />
      <br />
      <br />

      <el-button type="info" @click="uppassword()">修改</el-button>
    </div>
  </div>

</template>

<script>
  export default {
    name: 'uppassword',
    data: function() {
      return {
        uid: 0,
        customer: '',
        oldpassword: '',
        newpassword: '',
        newpasswords: ''
      }
    },
    methods: {
      uppassword() {
        this.$axios({
            method: "post",
            url: "/lc/login",
            data:{
              customer: this.customer,
              password: this.oldpassword
              }
          })
          .then(response => {
            if (response.data.code == 1) {
              if(this.newpassword == this.newpasswords){
                this.$axios({
                    method:"post",
                    url:"/lc/uppassword",
                    data:{uid: this.uid,
                    password: this.newpasswords}
                  })
                  .then(response => {
                    if (response.data.code == 1) {
                      this.$alert(response.data.desc)
                      this.$router.push("/")
                    } else {
                      this.$alert(response.data.desc)
                    }
                  })
              }else{
                this.$alert("输入两次密码不相同，请重新输入！")
              }
            } else {
              this.$alert(response.data.desc)
            }
          })
      }
    },
    mounted() {
      if (sessionStorage.getItem('uid') == null) {
        this.$router.push("/")
      } else {
        this.uid = sessionStorage.getItem('uid')
        this.customer = sessionStorage.getItem('customer')
      }
    }
  }
</script>

<style scoped="scoped">
  .top {
    float: left;
    margin-left: 35%;
  }

  .department {
    margin-left: 8%;
  }

  .second {
    float: left;
    margin-top: 4%;
    margin-left: -10%;
  }

  .two {
    margin-left: -10%;
  }

  .el-input {
    width: 67%;
  }

  .three {
    margin-left: -15%;
  }

  .four {
    margin-left: -15%;
  }

  .five {
    margin-left: -20%;
  }

  .el-button {
    margin-left: 30%;
  }
</style>
