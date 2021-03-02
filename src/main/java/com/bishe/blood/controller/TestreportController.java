package com.bishe.blood.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.R;
import com.bishe.blood.entity.Testreport;
import com.bishe.blood.service.AddressService;
import com.bishe.blood.service.TestreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 血液检测报表控制层
 */

@RestController
@RequestMapping("/testreport")
public class TestreportController {

    @Autowired
    private TestreportService testreportService;

    @PostMapping("/save")
    public R save(@RequestBody Testreport testreport){
        System.out.println(testreport);
        Testreport byId = testreportService.getById(testreport.getAppointmentId());
        if (byId != null) {
            int i = testreportService.changeStatus(testreport.getAppointmentId(), testreport.getStatus());
            return new R();
        }

        boolean save = testreportService.save(testreport);
        if (save) {
            return new R();
        } else {
            return new R(20001, "服务异常，保存失败！");
        }
    }

    @GetMapping("/getById")
    public R getById(int id) {
        return new R(testreportService.getById(id));
    }

    @GetMapping("/changeStatus")
    public R changeStatus(int appointmentId, int status) {
        int i = testreportService.changeStatus(appointmentId, status);
        if (i == 1) {
            return new R();
        } else {
            return new R(20001, "服务异常，血液状态修改失败！");
        }
    }

}
