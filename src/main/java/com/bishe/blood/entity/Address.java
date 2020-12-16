package com.bishe.blood.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/***
 * 标注的经纬度 实体类
 */
public class Address {
    @TableId(type = IdType.AUTO)
    private int id;

    private double lng;

    private double lat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}
