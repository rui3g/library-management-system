package cn.tjrac.sytstem.vo;

/**
 * @author Rui3g
 * @date 2020/3/31 16:38
 */
public class OrderVo {
    private String department;
    private String grade;
    private String profession;
    private String bookName;
    private String press;
    private Integer bookPrice;
    private String bookNumber;//书号
    private String author;
    private String edition;//版次
    private Integer teacherBookCount;//教师用书数量
    private Integer studentBookQuantity;//学生用书
    private String teacherName;
    private String teacherTel;
    private String bookDirectorTel;//教材负责人电话
    private String remark;

    @Override
    public String toString() {
        return "OrderVo{" +
                "department='" + department + '\'' +
                ", grade='" + grade + '\'' +
                ", profession='" + profession + '\'' +
                ", bookName='" + bookName + '\'' +
                ", press='" + press + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookNumber='" + bookNumber + '\'' +
                ", author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                ", teacherBookCount=" + teacherBookCount +
                ", studentBookQuantity=" + studentBookQuantity +
                ", teacherName='" + teacherName + '\'' +
                ", teacherTel='" + teacherTel + '\'' +
                ", bookDirectorTel='" + bookDirectorTel + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Integer getTeacherBookCount() {
        return teacherBookCount;
    }

    public void setTeacherBookCount(Integer teacherBookCount) {
        this.teacherBookCount = teacherBookCount;
    }

    public Integer getStudentBookQuantity() {
        return studentBookQuantity;
    }

    public void setStudentBookQuantity(Integer studentBookQuantity) {
        this.studentBookQuantity = studentBookQuantity;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherTel() {
        return teacherTel;
    }

    public void setTeacherTel(String teacherTel) {
        this.teacherTel = teacherTel;
    }

    public String getBookDirectorTel() {
        return bookDirectorTel;
    }

    public void setBookDirectorTel(String bookDirectorTel) {
        this.bookDirectorTel = bookDirectorTel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
