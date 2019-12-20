package com.zlx.my_ssm.domain;

/**
 * 会员实体类
 */
public class Member {
    private String id; //会员UUID 无意义 系统自动生成
    private String name;//会员名称
    private String nickname;//会员昵称
    private String phoneNum;//会员的联系电话
    private String email;//会员邮箱

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
