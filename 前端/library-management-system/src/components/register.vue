<template>
  <el-card class="box-card">
    <div class="register">
      <h1 style="text-align: center;margin-top: 10%;">注册新用户</h1>

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
          <span class="three">请重复密码：</span>
          <el-input v-model="passwords" placeholder="请重复输入密码" show-password></el-input>
        </div>

        <div class="fourth">
          <span class="department">系别：</span>
          <el-select v-model="departmentID" placeholder="请选择系别">
            <el-option v-for="d in departmentVoList" :key="d.departmentID" :label="d.department" :value="d.departmentID">
            </el-option>
          </el-select>
        </div>

        <div class="fifth">
          <span class="department">身份：</span>
          <el-select v-model="value" clearable placeholder="请选择身份">
            <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
            </el-option>
          </el-select>
        </div>

        <div class="btn">
          <el-row>
            <el-button type="primary" @click="login()">提交</el-button>
            <el-button type="primary" @click="goregister()">返回</el-button>
          </el-row>
        </div>
      </div>

    </div>
  </el-card>

</template>

<script>
  export default {
    name: 'register',
    data: function() {
      return {
        value: '',
        options: [{
          value: '1',
          label: '教师'
        }, {
          value: '2',
          label: '系主任'
        }, {
          value: '3',
          label: '系教务助理'
        }, {
          value: '4',
          label: '教务处'
        }],
        departmentVoList: [],
        departmentID: '',
        d: '',
        customer: '',
        password: '',
        passwords: '',
        status: 0
      }
    },
    methods: {
      goregister () {
        this.$router.push({'name': 'login'})
      },
      login() {
        if (this.password !== this.passwords) {
          this.$alert("输入两次密码不相同，请重新输入！")
        } else {
          this.$axios({
              method:"post",
              url:"/lc/register",
              data:{
                  customer: this.customer,
                  password: this.password,
                  type: this.value,
                  departmentID: this.departmentID,
                  status: this.status
                  }
            })
            .then(response => {
              if (response.data.code == 1) {
                this.$alert(response.data.desc)
                this.$router.push({
                  'name': 'login'
                })
              } else {
                this.$alert(response.data.desc)
              }
            })

        }

      }
    },
    mounted() {
      this.$axios({
        method:"post",
        url:"/lc/dgplist"
      }).then(response => {
          this.departmentVoList = response.data.result.departmentVoList
        })
    }
  }
</script>

<style scoped="scoped">
  /* * {
    margin: 0;
    padding: 0;
  } */

  /* #xx { */
  /* background: #fff url("../../assets/images/5.jpg") no-repeat; */
  /* background-size: cover;
    height: 100%;
    width: 100%;
    position: page;
    top: 0px;
    left: 0px;
    right: 0px;
    bottom: 0px;
    background-color: #606266; */
  /* } */

  /* body {
    background-color: rgb(23, 45, 67);
  } */

  .box-card {
    width: 100%;
    height: 1000px;
    background-color: #606266;
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
    margin-left: -4.5%;
  }

  .fourth{
    margin-top: 2%;
  }

  .fifth{
    margin-top: 2%;
  }
</style>
