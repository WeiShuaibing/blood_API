package com.bishe.blood.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bishe.blood.entity.*;
import com.bishe.blood.service.AppointmentService;
import com.bishe.blood.service.CarefulService;
import com.bishe.blood.service.TestreportService;
import com.bishe.blood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 注意事项控制层
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TestreportService testreportService;
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/login")
    public R login(@RequestBody User user) {
        R r = userService.verifyLogin(user);
        return r;
    }

    @PostMapping("/save")
    public R save(@RequestBody User user){
        boolean b = userService.saveOrUpdate(user);
        if (b) {
            return new R();
        } else {
            return new R(20001,"服务异常，保存失败！");
        }
    }

    @GetMapping("/deleteById")
    public R deleteById(int id){
        boolean b = userService.removeById(id);
        if (b) {
            return new R();
        } else {
            return new R(20001,"服务异常，删除失败！");
        }
    }

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize) {
        Page<User> messagePage = new Page<>(pageNum, pageSize);
        QueryWrapper<User> query = Wrappers.<User>query();
        query.orderByDesc("user_id");
        Page<User> page = userService.page(messagePage, query);

        for (User u : page.getRecords()) {
            QueryWrapper<Appointment> numQuery = Wrappers.<Appointment>query();
            numQuery.eq("user_id", u.getUserId()).in("status", 2, 3);
            u.setDonationNum(appointmentService.count(numQuery));
            u.setBloodMM(appointmentService.totalMM(u.getUserId()));
        }

        return new R(page);
    }

    @GetMapping("/info")
    public R info(@RequestHeader String Token){
        return new R(userService.getById(Token.split("_")[1]));
    }

    @GetMapping("/getUserById")
    public R getUserById(int id) {
        return new R(userService.getById(id));
    }

    @GetMapping("/getBloodInfo")
    public R getBloodInfo(@RequestHeader String Token) {
        String userId = Token.split("_")[1];
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", userService.getById(userId));

        QueryWrapper<Testreport> typeQuery = Wrappers.<Testreport>query();
        typeQuery.eq("user_id", userId).orderByDesc("create_date").last("limit 1");
        map.put("bloodType", testreportService.getOne(typeQuery).getBloodType());

        QueryWrapper<Appointment> numQuery = Wrappers.<Appointment>query();
        numQuery.eq("user_id", userId).in("status", 2, 3);
        map.put("totalNum", appointmentService.count(numQuery));

        map.put("totalMM", appointmentService.totalMM(Integer.parseInt(userId)));

        return new R(map);
    }
}
