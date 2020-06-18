<template>
  <div class="form_wapper">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>入库填写</span>
      </div>
      <el-button @click="addNewWay" size="mini" class="new_btn" type="primary" plain> + 新增入库记录</el-button>
      <el-form :model="formData" ref="elForm" :inline="true" size="mini">
        <template v-for="(k,index) in formData.lists">
          <el-form-item label="书号" :prop="'lists.' + index +'.bookNumber'" :ref="index+'bookNumber'" :rules=" { required: true, message: '请填写书号', trigger: 'blur' }">
            <el-input v-model="k.bookNumber"></el-input>
          </el-form-item>
          <el-form-item label="书名" :ref="index+'bookName'" :prop="'lists.' + index +'.bookName'" :rules=" { required: true, message: '请填写书号', trigger: 'blur' }">
            <el-input v-model="k.bookName"></el-input>
          </el-form-item>
          <el-form-item label="价格" :ref="index+'bookPrice'" :prop="'lists.' + index +'.bookPrice'" :rules=" { required: true, message: '请填写价格', trigger: 'blur' }">
            <el-input v-model="k.bookPrice"></el-input>
          </el-form-item>
          <el-form-item label="学生用书量" :ref="index+'studentBookQuantity'" :prop="'lists.' + index +'.studentBookQuantity'" :rules=" { required: true, message: '请填写数量', trigger: 'blur' }">
            <el-input v-model="k.studentBookQuantity"></el-input>
          </el-form-item>
          <el-form-item label="教师用书量" :ref="index+'teacherBookCount'" :prop="'lists.' + index +'.teacherBookCount'" :rules=" { required: true, message: '请填写数量', trigger: 'blur' }">
            <el-input v-model="k.teacherBookCount"></el-input>
          </el-form-item>
          <el-form-item label="出库日期" :ref="index+'dateTime'" :prop="'lists.' + index +'.dateTime'" :rules=" { required: true, message: '请填写日期', trigger: 'blur' }">
            <el-date-picker type="date" v-model="k.dateTime">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="系别" :ref="index+'department'" :prop="'lists.' + index +'.department'" :rules=" { required: true, message: '请填写系别', trigger: 'blur' }">
            <el-input v-model="k.department"></el-input>
          </el-form-item>
        </template>
      </el-form>
      <el-row type="flex" justify="center">
        <el-button @click="save" type="primary" size="medium">提交</el-button>
        <el-button @click="give" type="primary" size="medium">返回</el-button>
      </el-row>

    </el-card>
  </div>
</template>

<script>
  // 重复的校验规则:必填
  const baseRule = [{
    required: true,
    message: '请填写',
    trigger: 'blur'
  }]
  export default {
    name: 'HelloWorld',
    data() {
      return {
        formData: {
          lists: [{
            bookNumber: '', //联系方式：电话/手机
            bookName: '', //具体的联系方式的值
            bookPrice: '',
            studentBookQuantity: '',
            teacherBookCount: '',
            dateTime: '',
            department: '',
            rules: baseRule //基础校验规则:必填
          }]
        },
        dyRoutes: {},
        enterHouseJsonVos:''
      }
    },
    methods: {
      addNewWay() { //新增联系方式
        this.formData.lists.push({
         bookNumber: '', //联系方式：电话/手机
         bookName: '', //具体的联系方式的值
         bookPrice: '',
         studentBookQuantity: '',
         teacherBookCount: '',
         dateTime: '',
         department: '',
         rules: baseRule //基础校验规则:必填
        })
      },
      changeWays(data, index) {
        // 有值的话将自己的校验手动清空
        if (data) {
          let getRefWays = index + 'bookNumber'
          this.$refs[getRefWays][0].clearValidate()
        }
        // 将值清空
        this.formData.lists[index].bookName = ''
        // 去除联系方式的格式校验
        let getRefs = index + ' bookName'
        this.$refs[getRefs][0].clearValidate()
        // 给表单加上新的校验
        this.formData.lists[index].rules = [this.inputRules[data]].concat(baseRule)
      },
      save() {
        this.$refs.elForm.validate(async (valid) => {
          if (valid) {
            let methosData = await this.getJson()
            this.$axios({
              method: "post",
              url: "/libraryManagement/insertorder",
              data:{enterHouseJsonVos: methosData}
            }).then(response => {
              console.log(response)
            })
            console.log(methosData)
            this.$message({
              message: '表单提交成功，查看提交值请打开F12',
              type: 'success'
            });
            this.$router.push({'name': 'enter_storage'})
            this.$router.go(0)
          } else {
            console.log('error submit!!');
            return false;
          }
        });

      },
      getJson() { //只取到要提交的值
        return new Promise((resolve, reject) => {
          let tempJson = JSON.parse(JSON.stringify(this.formData.lists));
          tempJson.map((item) => {
            delete item.rules
            return item
          })
          resolve(tempJson)
        })
      },
      give(){
        this.$router.push({'name': 'enter_storage'})
        this.$router.go(0);
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped="scoped">
  .new_btn {
    margin-bottom: 20px;
  }

  .box-card {
    height: 800px;
  }
  .el-form.el-form--inline{

  }
</style>
