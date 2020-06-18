<template>
  <div id="xx">
    <div class="problem">
      <h1>公&nbsp;&nbsp;告&nbsp;&nbsp;发&nbsp;&nbsp;布</h1>
    </div>
    <div class="areatext">
    <el-input type="textarea" :rows="24" placeholder="请输入内容" v-model="textarea">
    </el-input>
    </div>
    <div id="btn">
      <el-button  type="primary" @click="takego">确定</el-button>
      <el-button  type="primary"@click="returnfor">取消</el-button>
    </div>
  </div>

</template>

<script>
  export default {
    data() {
      return {
        textarea: ''
      }
    },
    methods:{
      takego (){
        this.$axios({
          method: "post",
          url: "/System/insertNotice",
          data: {content:this.textarea}
        }).then(response => {
          console.log(response)
          if (response.data.code == "1") {
            this.$message({
              message: '发布成功',
              type: 'success'
            });
          } else {
            this.$message({
              message: '发布失败，网络出错',
              type: 'success'
            });
          }
        })
        this.$router.push({'name': 'first'})
      },
      returnfor (){
        this.$router.push({'name': 'first'})
      }
    }
  }
</script>

<style scoped="scoped">
  #xx{
    width: 100%;
    height: 1000px;
  }
  .problem {
    float: left;
    text-align: center;
    margin-left: 35%;
    margin-top: 2%;
  }
  .areatext{
    width: 50%;
    float: left;
    text-align: center;
    margin-left: 15%;
    margin-top: 2%;
  }
  #btn{
    float: left;
    margin-left: 57%;
    margin-top: 2%;
  }
</style>
