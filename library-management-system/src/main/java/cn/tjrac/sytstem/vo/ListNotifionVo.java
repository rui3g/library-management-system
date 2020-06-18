package cn.tjrac.sytstem.vo;

import java.util.List;

/**
 * @author Rui3g
 * @date 2020/4/15 15:58
 */
public class ListNotifionVo {

    private String orderNumber;
    private List<NotifionVo> notifionVos;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<NotifionVo> getNotifionVos() {
        return notifionVos;
    }

    public void setNotifionVos(List<NotifionVo> notifionVos) {
        this.notifionVos = notifionVos;
    }
}
