package cn.tjrac.sytstem.vo;

/**
 * @author Rui3g
 * @date 2020/4/1 12:16
 */
public class RepertoryVo {
    private String bookNumber;
    private String bookName;
    private Integer bookPrice;
    private Integer repertoryQuantity;

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

    public Integer getRepertoryQuantity() {
        return repertoryQuantity;
    }

    public void setRepertoryQuantity(Integer repertoryQuantity) {
        this.repertoryQuantity = repertoryQuantity;
    }
}
