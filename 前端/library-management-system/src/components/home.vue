<template>
  <div id="web">
    <div id="printme">
    <div class="biao">
      <h1>教&nbsp;&nbsp;材&nbsp;&nbsp;预&nbsp;&nbsp;定&nbsp;&nbsp;表</h1>
    </div>
    <div id="tal">
      <el-table :data="tableData" stripe>
        <el-table-column prop="department" label="系别" width="90" align='center'>
        </el-table-column>
        <el-table-column prop="grade" label="年级" width="100" align='center'>
        </el-table-column>
        <el-table-column prop="profession" label="专业" width="80" align='center'>
        </el-table-column>
        <el-table-column prop="bookName" label="教材名称" width="110" align='center'>
        </el-table-column>
        <el-table-column prop="press" label="出版社" width="120" align='center'>
        </el-table-column>
        <el-table-column prop="bookPrice" label="价格" width="80" align='center'>
        </el-table-column>
        <el-table-column prop="bookNumber" label="书号" width="120" align='center'>
        </el-table-column>
        <el-table-column prop="author" label="作者" width="80" align='center'>
        </el-table-column>
        <el-table-column prop="edition" label="版次" width="100" align='center'>
        </el-table-column>
        <el-table-column prop="teacherBookCount" label="教师用书量" width="100" align='center'>
        </el-table-column>
        <el-table-column prop="studentBookQuantity" label="学生用书量" width="100" align='center'>
        </el-table-column>
        <el-table-column prop="teacherName" label="教师名称" width="100" align='center'>
        </el-table-column>
        <el-table-column prop="teacherTel" label="教师电话" width="120" align='center'>
        </el-table-column>
        <el-table-column prop="bookDirectorTel" label="负责人电话" width="120" align='center'>
        </el-table-column>
        <el-table-column prop="remark" label="备注" width="80" align='center'>
        </el-table-column>
      </el-table>
    </div>
    </div>
    <el-dialog title="订单核对" :visible.sync="dialogFormVisible">
      <input type="file" @change="importfxx(this)" accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel">
      </input>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="xe">确 定</el-button>
      </div>
    </el-dialog>
    <div id="btn">
      <el-button type="primary" @click="dialogFormVisible = true">订单核对</el-button>
      <el-button type="primary" @click="exportExcel()">导出</el-button>
      <el-button type="primary" v-print="'#printme'">打印</el-button>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'home',
    data() {
      return {
        tableData: [],
        title: '教材预定表',
        fileTemp: null,
        dialogTableVisible: false,
        dialogFormVisible: false,
        mehedata: ''
      }
    },
    methods: {
      //导出的方法
      exportExcel() {
        // this.downloadLoading = true
        import("../excel/Export2Excel").then(excel => {
          const multiHeader = [
            ['天津大学仁爱学院' + this.ss() + '年第' + this.ss2() + '学期教材预定表', '', '', '', '', '', '', '', '', '', '', '',
              '', '', ''
            ]
          ];
          const tHeader = ['系别', '年级', '专业', '教材名称', '出版社', '价格', '书号', '作者', '版次', '教师用书数量', '学生用书数量', '教师名称',
            '教师电话', '负责人电话', '备注'
          ];
          const filterVal = ['department', 'grade', 'profession', 'bookName', 'press', 'bookPrice', 'bookNumber',
            'author',
            'edition', 'teacherBookCount', 'studentBookQuantity', 'teacherName', 'teacherTel', 'bookDirectorTel', 'remark'
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
            filename: '天津大学仁爱学院' + this.ss() + '第' + this.ss2() + '学期' +'教材预定表'
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
      importfxx(obj) {
        let _this = this;
        console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxx1");
        let inputDOM = this.$refs.inputer;
        // 通过DOM取文件数据

        this.file = event.currentTarget.files[0];

        var rABS = false; //是否将文件读取为二进制字符串
        var f = this.file;

        var reader = new FileReader();
        //if (!FileReader.prototype.readAsBinaryString) {
        FileReader.prototype.readAsBinaryString = function(f) {
          var binary = "";
          var rABS = false; //是否将文件读取为二进制字符串
          var pt = this;
          var wb; //读取完成的数据
          var outdata;
          var reader = new FileReader();
          reader.onload = function(e) {
            var bytes = new Uint8Array(reader.result);
            var length = bytes.byteLength;
            for (var i = 0; i < length; i++) {
              binary += String.fromCharCode(bytes[i]);
            }
            var XLSX = require("xlsx");
            if (rABS) {
              wb = XLSX.read(btoa(fixdata(binary)), {
                //手动转化
                type: "base64"
              });
            } else {
              wb = XLSX.read(binary, {
                type: "binary"
              });
            }
            outdata = XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]); //outdata就是你想要的东西
            console.log(outdata);
            _this.$axios({
              method: "post",
              url: "/libraryManagement/selectorder",
              data: {
                orderVoList: outdata
              }
            }).then(response => {
              console.log(response)
              var m = response.data.code;
              _this.toast(m);
            })

          };
          reader.readAsArrayBuffer(f);
        };
        if (rABS) {
          reader.readAsArrayBuffer(f);
        } else {
          reader.readAsBinaryString(f);
        }
      },
      xe() {
        this.dialogFormVisible = false
        this.$message({
          message: '提交成功',
          type: 'success'
        });
      },
      toast(x) {
        if (x == "1") {
          this.$message({
            message: '核对成功,购买数量正确',
            type: 'success'
          });
        } else if (x == "2") {
          this.$message({
            message: '核对成功,数量有误',
            type: 'success'
          });
        } else {
          this.$message({
            message: '程序出错',
            type: 'success'
          });
        }
      }

    },
    mounted() {
      this.$axios({
        method: "post",
        url: "/libraryManagement/selectAllOrder"
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
  #web {
    width: 100%;
    height: 1000px;

  }

  #tal {
    margin-top: 50px;
    margin-left: 20px;
    width: 80%;
    float: left;
  }

  .biao {
    float: left;
    text-align: center;
    margin-left: 35%;
    margin-top: 2%;
  }

  #btn {
    float: left;
    margin-top: 2%;
    margin-left: 65%;
  }
</style>
