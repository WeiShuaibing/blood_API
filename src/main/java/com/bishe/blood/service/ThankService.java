package com.bishe.blood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bishe.blood.entity.Address;
import com.bishe.blood.entity.Thank;

public interface ThankService extends IService<Thank> {

    public int updateStatus(int user_id, int status);

}
