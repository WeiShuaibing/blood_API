package com.bishe.blood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentService extends IService<Appointment> {
    public int changeStatus(int appointmentId,int status);

    public int totalMM(@Param("userId") int userId);

}
