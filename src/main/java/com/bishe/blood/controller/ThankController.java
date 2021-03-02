package com.bishe.blood.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.R;
import com.bishe.blood.entity.Thank;
import com.bishe.blood.service.AddressService;
import com.bishe.blood.service.ThankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 献血地点控制层
 */

@RestController
@RequestMapping("/thank")
public class ThankController {

    @Autowired
    private ThankService thankService;

    @PostMapping("/save")
    public R save(@RequestBody Thank thank){
        boolean save = thankService.save(thank);
        return new R();
    }

    @GetMapping("/changeStatus")
    public R changeStatus(int userId, int status) {
        int i = thankService.updateStatus(userId, status);
        return new R();
    }

    @GetMapping("/getMyThank")
    public R getMyThank(@RequestHeader String token) {
        String userId = token.split("_")[1];
        QueryWrapper<Thank> query = Wrappers.query();
        query.eq("user_id", userId).eq("status", 0).orderByDesc("id");
        Thank one = thankService.getOne(query);

        // 将感谢信息状态置为已读
        thankService.updateStatus(Integer.valueOf(userId), 1);
        return new R(one);
    }

}
