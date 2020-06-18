package cn.tjrac.sytstem.vo;

/**
 * @author Rui3g
 * @date 2020/3/31 18:22
 */
public class EnterHouseVo {
    private String bookNumber;
    private String bookName;
    private Integer bookPrice;
    private Integer enterQuantity;
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

    public Integer getEnterQuantity() {
        return enterQuantity;
    }

    public void setEnterQuantity(Integer enterQuantity) {
        this.enterQuantity = enterQuantity;
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
