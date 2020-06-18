<template>
  <div id="out">
    <div id="printme">
    <div class="problem">
      <h1>费&nbsp;&nbsp;用&nbsp;&nbsp;通&nbsp;&nbsp;知&nbsp;&nbsp;单</h1>
    </div>
    <div class="talb">
      <el-table :data="tableData" border show-summary :summary-method="getSummaries" style="width: 100%">
        <el-table-column prop="orderNumber" label="订单号">
        </el-table-column>
        <el-table-column prop="bookNumber" sortable label="书号">
        </el-table-column>
        <el-table-column prop="bookName" sortable label="书名">
        </el-table-column>
        <el-table-column prop="bookPrice" sortable label="价格">
        </el-table-column>
        <el-table-column prop="quantity" sortable label="数量">
        </el-table-column>
        <el-table-column prop="sumPrice" sortable label="总价">
        </el-table-column>
      </el-table>
    </div>
    </div>
    <div id="btn">
      <el-button  type="primary" @click="exportExcel()">导出</el-button>
      <el-button  type="primary" v-print="'#printme'">打印</el-button>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [],
        title: '费用通知单'
      }
    },
    methods: {
      exportExcel() {
        // this.downloadLoading = true
        import("../excel/Export2Excel").then(excel => {
          const multiHeader = [
            ['天津大学仁爱学院费用通知单', '', '', '', '', ''
            ]
          ];
          const tHeader = ['订单号','书号','教材名称','价格','数量', '总价'
          ];
          const filterVal = ['orderNumber','bookNumber','bookName','bookPrice','quantity','sumPrice'
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
            filename: '天津大学仁爱学院费用通知单'
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
       getSummaries(param) {
               const { columns, data } = param;
               const sums = [];
               columns.forEach((column, index) => {
                 if (index === 0) {
                   sums[index] = '总价';
                   return;
                 }
                 const values = data.map(item => Number(item[column.property]));
                 if (!values.every(value => isNaN(value))&&index==5) {
                   sums[index] = values.reduce((prev, curr) => {
                     const value = Number(curr);
                     if (!isNaN(value)) {
                       return prev + curr;
                     } else {
                       return prev;
                     }
                   }, 0);
                   sums[index] += ' 元';
                 } else {
                   sums[index] = ' ';
                 }
               });

               return sums;
             }
    },
    mounted() {
      this.$axios({
        method: "post",
        url: "/outManagement/selectNotifion"
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
  #out {
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
    margin-left: 30%;
    margin-top: 2%;
  }
  #btn{
    float: left;
    margin-left: 65%;
    margin-top: 2%;
  }
</style>
