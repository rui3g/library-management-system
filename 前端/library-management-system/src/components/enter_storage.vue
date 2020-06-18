<template>
  <div id="enter">
    <div id="printme">
    <div class="problem">
      <h1>入&nbsp;&nbsp;库&nbsp;&nbsp;记&nbsp;&nbsp;录</h1>
    </div>
    <div class="talb">
      <el-table :data="tableData" stripe>
        <el-table-column prop="bookNumber" label="书号" width="180" align='center'>
        </el-table-column>
        <el-table-column prop="bookName" label="书名" width="180" align='center'>
        </el-table-column>
        <el-table-column prop="bookPrice" label="价格" width="110" align='center'>
        </el-table-column>
        <el-table-column prop="enterQuantity" label="数量" width="110" align='center'>
        </el-table-column>
        <el-table-column prop="dateTime" label="入库时间" width="320" align='center'>
        </el-table-column>
        <el-table-column prop="department" label="系别">
        </el-table-column>
      </el-table>
    </div>
    </div>
    <div id="btn">
      <el-button  type="primary" @click="takeout">入库</el-button>
      <el-button  type="primary" @click="exportExcel()">导出</el-button>
      <el-button  type="primary" v-print="'#printme'">打印</el-button>
    </div>
  </div>
</template>

<script>
  import {wordExport} from '../utils/jquery.wordexport.js'
  export default {
    data() {
      return {
        tableData: [],
        title: '入库记录'
      }
    },
    methods: {
      exportExcel() {
        // this.downloadLoading = true
        import("../excel/Export2Excel").then(excel => {
          const multiHeader = [
            ['天津大学仁爱学院入库记录表', '', '', '', '', ''
            ]
          ];
          const tHeader = ['书号','教材名称','价格','数量','入库时间', '系别'
          ];
          const filterVal = ['bookNumber','bookName','bookPrice','enterQuantity','dateTime','department'
          ];
          let list = this.tableData;
          const data = this.formatJson(filterVal, list);
          //进行所有表头的单元格合并，建议一行一行来，不然容易整乱
          const merges = [
            "A1:O1"
          ];
          //  const merges = ['A1:A2', 'B1:B2', 'C1:I2','J1:P2']
          excel.export_json_to_excel({
            multiHeader, //这里是第一行的表头
            header: tHeader, //这里应该是算第三行的表头
            data,
            merges,
            filename: '天津大学仁爱学院入库记录表'
          });
          // this.downloadLoading = false
        });
      },
      ss() {
        var date = new Date();
        return date.getFullYear() - 1 + "-" + date.getFullYear();
      },
      ss2() {
        var date = new Date();
        if (date.getMonth() >= 9) {
          return 1;
        } else if (date.getMonth() < 9) {
          return 2;
        }
      },
      formatJson(filterVal, jsonData) {
        return jsonData&&jsonData.map(v =>
          filterVal.map(j => {
            if (j === "timestamp") {
              return parseTime(v[j]);
            } else {
              return v[j];
            }
          })
        );
      },
      takeout(){
        this.$router.push({'name': 'take_in'})
      }

    },
    mounted() {
      this.$axios({
        method: "post",
        url: "/libraryManagement/selectEnterHouse"
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
  #enter {
    width: 100%;
    height: 1000px;

  }

  .talb {
    margin-top: 50px;
    margin-left: 100px;
    width: 70%;
    float: left;
  }

  .problem {
    float: left;
    text-align: center;
    margin-left: 35%;
    margin-top: 2%;
  }
  #btn{
    float: left;
    margin-left: 60%;
    margin-top: 2%;
  }
</style>
