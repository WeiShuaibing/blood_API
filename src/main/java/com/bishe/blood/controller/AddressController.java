package com.bishe.blood.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.Careful;
import com.bishe.blood.entity.R;
import com.bishe.blood.service.AddressService;
import com.bishe.blood.service.CarefulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 献血地点控制层
 */

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/save")
    public R save(@RequestBody Address address){
        QueryWrapper<Address> query = Wrappers.<Address>query();
        query.eq("lng", address.getLng()).eq("lat", address.getLat());
        Address one = addressService.getOne(query);
        System.out.println(one);
        if (one == null) {
            boolean b = addressService.save(address);
            if (b) {
                return new R(20000, "新地点添加成功");
            } else {
                return new R(20001,"服务异常，保存失败！");
            }
        } else {
            addressService.remove(query);
            System.out.println(address);
            System.out.println("嘻嘻嘻嘻嘻嘻嘻嘻寻寻寻寻寻");
            return new R(20000,"已移除该地点");
        }


    }

   @GetMapping("/getAll")
    public R getAll() {
        List<Address> list = addressService.list();
        return new R(list);
    }

}
