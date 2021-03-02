package com.bishe.blood.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bishe.blood.entity.Appointment;
import com.bishe.blood.entity.R;
import com.bishe.blood.entity.User;
import com.bishe.blood.service.AppointmentService;
import com.bishe.blood.service.TestreportService;
import com.bishe.blood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 血库管理
 */
@RestController
@RequestMapping("/xueku")
public class XuekuController {

    @Autowired
    private AppointmentService service;
    @Autowired
    private UserService userService;
    @Autowired
    private TestreportService testreportService;

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize) {
        LocalDateTime dateOfBefore10Day = LocalDateTime.now().plusDays(-365);
        String timeOfBefore365Day = dateOfBefore10Day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        QueryWrapper<Appointment> query = Wrappers.<Appointment>query();
        query.eq("status", 2).or().eq("status", 3);
        query.orderByDesc("appointment_id");

        Page<Appointment> page = new Page<>(pageNum, pageSize);
        Page<Appointment> resPage = service.page(page, query);

        for (Appointment appointment : resPage.getRecords()) {
            User u = userService.getById(appointment.getUserId());
            appointment.setSex(u.getSex());
            appointment.setAge(u.getAge());
            appointment.setUserName(u.getName());
            appointment.setTestreport(testreportService.getById(appointment.getAppointmentId()));

            if (appointment.getStatus() == 2) {
                String ruKuDate = new SimpleDateFormat("yyyy-MM-dd").format(appointment.getUpdateDate());
                if (ruKuDate.compareTo(timeOfBefore365Day) == -1) {
                    appointment.setIsGuoQi("Yes");
                }
            }
        }
        return new R(resPage);
    }

}
