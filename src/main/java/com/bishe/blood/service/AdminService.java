package com.bishe.blood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bishe.blood.entity.Admin;
import com.bishe.blood.entity.R;

public interface AdminService extends IService<Admin> {

    public R verifyLogin(Admin admin);

}
