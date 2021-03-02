package com.bishe.blood.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/***
 * 血液检测报表 实体类
 */
public class Testreport {

    @TableId
    private int appointmentId;
    private int userId;
    private int height;
    private int weight;
    private String bloodType;
    private int bloodPressure;
    private String hepatitis;
    private String aizi;
    private String meidu;
    private int status; // 检验状态 0无状态，1血液检验成功 2 血液检验失败

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate; //创建时间


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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getHepatitis() {
        return hepatitis;
    }

    public void setHepatitis(String hepatitis) {
        this.hepatitis = hepatitis;
    }

    public String getAizi() {
        return aizi;
    }

    public void setAizi(String aizi) {
        this.aizi = aizi;
    }

    public String getMeidu() {
        return meidu;
    }

    public void setMeidu(String meidu) {
        this.meidu = meidu;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Testreport{" +
                "appointmentId=" + appointmentId +
                ", userId=" + userId +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodType='" + bloodType + '\'' +
                ", bloodPressure=" + bloodPressure +
                ", hepatitis='" + hepatitis + '\'' +
                ", aizi='" + aizi + '\'' +
                ", meidu='" + meidu + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }
}
