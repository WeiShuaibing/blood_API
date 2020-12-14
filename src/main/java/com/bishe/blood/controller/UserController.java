package com.bishe.blood.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bishe.blood.entity.Careful;
import com.bishe.blood.entity.R;
import com.bishe.blood.entity.User;
import com.bishe.blood.service.CarefulService;
import com.bishe.blood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 注意事项控制层
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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
        query.orderByDesc("id");
        Page<User> page = userService.page(messagePage, query);
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

}
