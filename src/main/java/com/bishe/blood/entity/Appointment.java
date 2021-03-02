package com.bishe.blood.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/***
 * 预约实体类
 */
public class Appointment {
    @TableId(type = IdType.AUTO)
    private int appointmentId;
    private int userId;
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String sex;
    @TableField(exist = false)
    private int age;

    private int mm; //献血量

    @TableField(exist = false)
    private Testreport testreport;

    @TableField(exist = false)
    private String isGuoQi = "No";

    private String minzu;
    private String huji;
    private String hunyin;
    private String wenhua;
    private String phone;
    private String address;
    private String type;
    private String xianxueaddress;

    private int status = 0; // 状态，状态，默认0,  1代表预约取消， 2入血库，3出库. -1 血液删除
    private Date date; // 预约日期

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public String getIsGuoQi() {
        return isGuoQi;
    }

    public void setIsGuoQi(String isGuoQi) {
        this.isGuoQi = isGuoQi;
    }

    public Testreport getTestreport() {
        return testreport;
    }

    public void setTestreport(Testreport testreport) {
        this.testreport = testreport;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu;
    }

    public String getHuji() {
        return huji;
    }

    public void setHuji(String huji) {
        this.huji = huji;
    }

    public String getHunyin() {
        return hunyin;
    }

    public void setHunyin(String hunyin) {
        this.hunyin = hunyin;
    }

    public String getWenhua() {
        return wenhua;
    }

    public void setWenhua(String wenhua) {
        this.wenhua = wenhua;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getXianxueaddress() {
        return xianxueaddress;
    }

    public void setXianxueaddress(String xianxueaddress) {
        this.xianxueaddress = xianxueaddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", minzu='" + minzu + '\'' +
                ", huji='" + huji + '\'' +
                ", hunyin='" + hunyin + '\'' +
                ", wenhua='" + wenhua + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", xianxueaddress='" + xianxueaddress + '\'' +
                ", status=" + status +
                ", date=" + date +
                ", createDate=" + createDate +
                '}';
    }
}
