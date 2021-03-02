package com.bishe.blood.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bishe.blood.dao.AddressDao;
import com.bishe.blood.dao.TestreportDao;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.Testreport;
import com.bishe.blood.service.AddressService;
import com.bishe.blood.service.TestreportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class TestreportServiceImpl extends ServiceImpl<TestreportDao, Testreport> implements TestreportService {

    @Autowired
    private TestreportDao dao;

    @Override
    public int changeStatus(int appointmentId, int status) {
        return dao.changeStatus(appointmentId, status);
    }
}
