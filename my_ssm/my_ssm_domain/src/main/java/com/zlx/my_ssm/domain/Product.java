package com.zlx.my_ssm.domain;

import com.zlx.my_ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Product {
    private String id; //主键 UUID 系统生成的
    private String productNum;//产品编号 唯一
    //将字符串类型的日期转(前端页面用户输入的日期为字符串类型的日期)换为Date类型的日期(数据库中存的是Date类型的日期)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;//出发时间
    private String productName;//产品名称
    private String cityName;//出发城市
    private String departureTimeStr; //出发时间(字符串类型 为了方便在控制台上展示)
    private String productPrice; //产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态(0:关闭 1：开启)
    private String productStatusStr; //状态(字符串类型 为了方便在控制台上进行展示)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        /**
         * 将日期转换为字符串显示到前端页面上
         */
        if (departureTime != null) {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            departureTimeStr = DateUtils.dateToString(departureTime, pattern);
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {

        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        /**
         * 将 0/1 转换成 关闭/开启 在页面上显示
         */
        if (productStatus != null) {
            if (productStatus == 1) {
                productStatusStr = "开启";
            }
            if (productStatus == 0) {
                productStatusStr = "关闭";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
