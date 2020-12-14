package com.bishe.blood.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

 /**
 * 献血用户实体类
 */
public class User {

    @TableId(type = IdType.AUTO)
    private int userId;

    private String name; // 名字
    private int age;
    private String sex; // 性别
    private String phone; // 手机号也是系统账号
    private String password;
    private String address; // 地址
    @TableField(exist = false)
    private String avatar="https://s2.ax1x.com/2019/07/17/ZLWJSA.gif?imageView2/1/w/80/h/80"; // 头像url

    @TableField(exist = false)
    private String roles  = "user"; // 角色

    @TableField(exist = false)
    private int donationNum; // 献血次数
    @TableField(exist = false)
    private int bloodMM; // 献血的总毫升数

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate; //更新时间

     public String getAvatar() {
         return avatar;
     }

     public void setAvatar(String avatar) {
         this.avatar = avatar;
     }

     public String getRoles() {
         return roles;
     }

     public void setRoles(String roles) {
         this.roles = roles;
     }

     public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDonationNum() {
        return donationNum;
    }

    public void setDonationNum(int donationNum) {
        this.donationNum = donationNum;
    }

    public int getBloodMM() {
        return bloodMM;
    }

    public void setBloodMM(int bloodMM) {
        this.bloodMM = bloodMM;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", donationNum=" + donationNum +
                ", bloodMM=" + bloodMM +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
