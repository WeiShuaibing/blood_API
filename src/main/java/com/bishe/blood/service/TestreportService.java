package com.bishe.blood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.Testreport;

public interface TestreportService extends IService<Testreport> {

    public int changeStatus(int appointmentId,int status);

}
