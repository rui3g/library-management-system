package cn.tjrac.sytstem.vo;

/**
 * @author Rui3g
 * @date 2020/4/21 17:47
 */
public class EnterHouseJsonVo {
    private String bookNumber;
    private String bookName;
    private Integer bookPrice;
    private Integer studentBookQuantity;//学生用书
    private Integer teacherBookCount;//教师用书数量
    private String dateTime;
    private String department;

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
