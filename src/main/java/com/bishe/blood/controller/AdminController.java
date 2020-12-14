package com.bishe.blood.controller;

import com.bishe.blood.entity.Admin;
import com.bishe.blood.entity.R;
import com.bishe.blood.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员控制层
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @PostMapping("/login")
    public R login(@RequestBody Admin admin){
        R r = adminService.verifyLogin(admin);
        return r;
    }

    /**
     * 获取用户基本信息
     * @return
     */
    @GetMapping("/info")
    public R info(@RequestHeader String Token){
        return new R(adminService.getById(Token.split("_")[1]));
    }

    @GetMapping("/logout")
    public R logout(){

        return new R();
    }

    @PostMapping("/save")
    public R save(@RequestBody Admin admin) {
        boolean b = adminService.saveOrUpdate(admin);
        if (b) {
            return new R();
        } else  {
            return new R(20001, "服务异常，保存失败！");
        }
    }

    @GetMapping("deleteById")
    public R deleteById(int id) {
        boolean b = adminService.removeById(id);
        if (b) {
            return new R();
        } else {
            return new R(20001, "服务异常，删除失败！");
        }
    }

    @GetMapping("/getAll")
    public R getAll() {
        List<Admin> list = adminService.list();
        return new R(list);
    }

}
