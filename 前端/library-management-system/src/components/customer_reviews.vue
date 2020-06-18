<template>
  <div id="out">
    <div class="problem">
      <h1>等&nbsp;&nbsp;待&nbsp;&nbsp;审&nbsp;&nbsp;核</h1>
    </div>
    <div class="talb">
      <el-table
          :data="tableData"
          border
          style="width: 60%">
          <el-table-column
            fixed
            prop="uid"
            label="序号"
            width="150">
          </el-table-column>
          <el-table-column
            prop="customer"
            label="用户"
            width="150">
          </el-table-column>
          <el-table-column
            prop="type"
            label="权限"
            width="150">
          </el-table-column>
          <el-table-column
            prop="departmentID"
            label="系别号"
            width="150">
          </el-table-column>
          <el-table-column
            fixed="right"
            label="操作"
            width="180">
            <template slot-scope="scope">
              <el-button @click="outuser(scope.row)" type="primary" size="small">拉黑</el-button>
              <el-button type="primary" size="small" @click="takeuser(scope.row)" >通过</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="remark"><span>注：权限{1=老师，2=系教务助理，3=教导主任，4=教材管理员}</span></div>
    </div>
  </div>
</template>

<script>
  import {wordExport} from '../utils/jquery.wordexport.js'
  export default {
     data() {
          return {
            tableData: [],
            title: '用户审核'
          }
        },
        methods: {
               outuser(row){
                 console.log(row);
                 this.$axios({
                   method: "post",
                   url: "/System/delUser",
                   data:{uid:row.uid}
                 }).then(response => {
                   console.log(response)
                   if (response.data.code == "1") {
                    this.$message({
                      message: '拒绝成功',
                      type: 'success'
                    });
                   } else {
                     this.$message({
                       message: '审核失败',
                       type: 'success'
                     });
                   }
                 })
               },
               takeuser(row){
                 this.$axios({
                   method: "post",
                   url: "/System/updateUserStatus",
                   data:{uid:row.uid}
                 }).then(response => {
                   console.log(response)
                   if (response.data.code == "1") {
                    this.$message({
                      message: '审核成功',
                      type: 'success'
                    });
                   } else {
                     this.$message({
                       message: '审核失败',
                       type: 'success'
                     });
                   }
                 })
               }
        },
        mounted() {
          this.$axios({
            method: "post",
            url: "/System/selectUserInfo"
          }).then(response => {
            console.log(response)
            if (response.data.code == "1") {
              this.tableData = response.data.result;
            } else {
              this.$toast('获取参数失败')
            }
          })
        }
  }
</script>

<style scoped="scoped">
  #out{
      width: 100%;
      height: 1000px;
  }
  .talb{
    margin-top: 50px;
    margin-left: 12%;
    width: 70%;
    float: left;
  }
  .problem{
    float: left;
    text-align: center;
    margin-left: 30%;
    margin-top: 2%;
  }
  .remark{
    color: #99A9BF;
    font-size: 14px;
    margin-top: 1%;
  }
</style>
