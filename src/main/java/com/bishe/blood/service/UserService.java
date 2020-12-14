package com.bishe.blood.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bishe.blood.entity.Admin;
import com.bishe.blood.entity.R;
import com.bishe.blood.entity.User;

public interface UserService extends IService<User> {

    public R verifyLogin(User user);

}
