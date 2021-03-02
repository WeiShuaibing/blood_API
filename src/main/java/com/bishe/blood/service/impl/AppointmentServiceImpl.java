package com.bishe.blood.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bishe.blood.dao.AddressDao;
import com.bishe.blood.dao.AppointmentDao;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.Appointment;
import com.bishe.blood.service.AddressService;
import com.bishe.blood.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentDao, Appointment> implements AppointmentService {

    @Autowired
    private AppointmentDao dao;
    @Override
    public int changeStatus(int appointmentId, int status) {
        return dao.changeStatus(appointmentId, status);
    }


    @Override
    public int totalMM(int userId) {
        return dao.totalMM(userId);
    }
}
