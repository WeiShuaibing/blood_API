package com.bishe.blood.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 感谢用户实体类
 */
public class Thank {

    @TableId(type = IdType.AUTO)
    private int id;

    private int userId;

    private int status;

    @Override
    public String toString() {
        return "Thank{" +
                "id=" + id +
                ", userId=" + userId +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
