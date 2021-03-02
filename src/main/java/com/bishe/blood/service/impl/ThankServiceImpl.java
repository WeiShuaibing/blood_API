package com.bishe.blood.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bishe.blood.dao.AddressDao;
import com.bishe.blood.dao.ThankDao;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.Thank;
import com.bishe.blood.service.AddressService;
import com.bishe.blood.service.ThankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class ThankServiceImpl extends ServiceImpl<ThankDao, Thank> implements ThankService {

    @Autowired
    public ThankDao thankDao;

    @Override
    public int updateStatus(int user_id, int status) {
        return thankDao.updateStatus(user_id, status);
    }
}
