package com.zlx.my_ssm.domain;

import com.zlx.my_ssm.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Orders {
    private String id;//系统自动生成的UUID 无意义
    private String orderNum;//订单编号，不为空，唯一
    private Date orderTime;//下单时间
    private String orderTimeStr;//下单时间(字符串类型，为了方便在前台进行展示)
    private Integer peopleCount;//出行人数
    private String orderDesc;//订单描述
    private Integer payType;//支付方式(0 支付宝 1 微信 2 其他支付方式)
    private String payTypeStr;//支付方式(字符串类型，方便在前端进行展示)
    private Integer orderStatus;//订单状态(0 未支付 1 已支付)
    private String orderStatusStr;//订单状态(字符串类型，方便在前端进行展示)
    private Product product;//产品id外键(一个产品有多个订单)
    private Member member;//会员id外键(一个会员有多个订单)
    private List<Traveller> travellers;//旅客id外键(一个旅客有多个订单)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            //将日期型的时间格式化为方便在前端展示的日期
            orderTimeStr = DateUtils.dateToString(orderTime, "yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //(0 支付宝 1 微信 2 其他支付方式)
        if(payType!=null){
            if(payType==0){
                payTypeStr = "支付宝";
            }
            if(payType==1){
                payTypeStr="微信";
            }
            if(payType==2){
                payTypeStr="其他支付方式";
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        //订单状态(0 未支付 1 已支付)
        if(orderStatus!=null){
            if(orderStatus == 0){
                orderStatusStr="未支付";
            }
            if(orderStatus == 1){
                orderStatusStr="已支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
}
