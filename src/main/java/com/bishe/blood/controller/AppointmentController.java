package com.bishe.blood.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bishe.blood.entity.*;
import com.bishe.blood.service.AdminService;
import com.bishe.blood.service.AppointmentService;
import com.bishe.blood.service.TestreportService;
import com.bishe.blood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 管理员控制层
 */

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private TestreportService testreportService;

    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );

    @PostMapping("/save")
    public R save(@RequestBody Appointment appointment) {
        boolean b = appointmentService.saveOrUpdate(appointment);
        if (b) {
            return new R();
        } else  {
            return new R(20001, "服务异常，保存失败！");
        }
    }

    @GetMapping("/deleteById")
    public R deleteById(int id) {
        boolean b = appointmentService.removeById(id);
        if (b) {
            return new R();
        } else {
            return new R(20001, "服务异常，删除失败！");
        }
    }

    @GetMapping("/reback")
    public R reback(int id) {
        UpdateWrapper<Appointment> update = new UpdateWrapper<>();
        update.eq("appointment_id", id).set("status", 1);
        boolean b = appointmentService.update(update);
        if (b) {
            return new R();
        } else {
            return new R(20001, "服务异常，更新失败！");
        }

    }

    @GetMapping("/getMyAppointment")
    public R getMyAppointment(@RequestHeader String token) {
        QueryWrapper<Appointment> query = Wrappers.<Appointment>query();
        query.eq("user_id", token.split("_")[1]).eq("status", 0);

        Appointment one = appointmentService.getOne(query);
        return new R(one);
    }

    @GetMapping("/changeAppointmentStatus")
    public R changeAppointmentStatus(int appointmentId, int status){
        int i = appointmentService.changeStatus(appointmentId, status);
        if (i == 1) {
            return new R();
        } else {
            return new R(20001, "服务异常，预约状态修改失败！");
        }
    }


    @GetMapping("/getAllAppointment")
    public R getAllAppointment(String status) {
        System.out.println(status);
        QueryWrapper<Appointment> query = Wrappers.<Appointment>query();
        query.eq("status", 0);

        List<Appointment> list = appointmentService.list(query);
        for (Appointment app : list) {
            User u = userService.getById(app.getUserId());
            app.setSex(u.getSex());
            app.setAge(u.getAge());
            app.setUserName(u.getName());
        }
        return new R(list);
    }


    /**
     * 根据用户id 获取10天内我的通知，如血液检测是否合格通知；血液入库通知，出库通知等
     */
    @GetMapping("/getMyBloodInfo")
    public R getMyBloodInfo(@RequestHeader String token) {
        Integer userId = Integer.parseInt(token.split("_")[1]);

        LocalDateTime dateOfBefore10Day = LocalDateTime.now().plusDays(-10);
        String timestampOfBefore10Day = dateOfBefore10Day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        QueryWrapper<Appointment> query = Wrappers.<Appointment>query();
        query.ge("create_date", timestampOfBefore10Day);
        query.eq("user_id", userId);
        List<Appointment> appointmentList = appointmentService.list(query);

        ArrayList<String> resMessage = new ArrayList<>();

        for (Appointment a : appointmentList) {
            if (a.getStatus() == 2) {
                resMessage.add("您" + sdf.format(a.getCreateDate()) + "预约的血液已经入库");
            }
            if (a.getStatus() == 3) {
                resMessage.add("您" + sdf.format(a.getCreateDate()) + "预约的血液已经出库");
            }
        }

        QueryWrapper<Testreport> testReportQuery = Wrappers.<Testreport>query();
        query.ge("create_date", timestampOfBefore10Day);
        query.eq("user_id", userId);
        List<Testreport> testReportList = testreportService.list(testReportQuery);
        for (Testreport testreport : testReportList) {
            if (testreport.getStatus() == 1) {
                resMessage.add(sdf.format(testreport.getCreateDate()) + " 您的血液通过了检测，为合格");
            }
            if (testreport.getStatus() == 2) {
                resMessage.add(sdf.format(testreport.getCreateDate()) + " 您的血液未通过检测，不能入库");
            }
        }
        return new R(resMessage);
    }

    /**
     * 根据个人id查询本人的所有献血状态
     */
    @GetMapping("/getMyBloodStatus")
    public R getMyBloodStatus(@RequestHeader String token) {
        String userId = token.split("_")[1];
        QueryWrapper<Appointment> query = Wrappers.<Appointment>query();
        query.eq("user_id", userId).ne("status", -1)
                .orderByDesc("appointment_id");
        return new R(appointmentService.list(query));
    }

    /**
     * 根据个人id查询本人的所有献血状态
     */
    @GetMapping("/getMyBloodStatus2")
    public R getMyBloodStatus2(int userId) {
        QueryWrapper<Appointment> query = Wrappers.<Appointment>query();
        query.eq("user_id", userId).ne("status", -1)
                .orderByDesc("appointment_id");
        return new R(appointmentService.list(query));
    }

    /**
     * 根据个人id查询本人的所有献血记录信息
     */
    @GetMapping("/getBloodRecord")
    public R getBloodRecord(@RequestHeader String token) {
        String userId = token.split("_")[1];
        QueryWrapper<Appointment> query = Wrappers.<Appointment>query();
        query.eq("user_id", userId).in("status", 0, 2,3)
                .orderByDesc("appointment_id");
        List<Appointment> list = appointmentService.list(query);
        for (Appointment appointment : list) {
            appointment.setTestreport(testreportService.getById(appointment.getAppointmentId()));
        }
        return new R(list);
    }

}
