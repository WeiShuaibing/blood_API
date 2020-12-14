package com.bishe.blood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.blood.entity.Admin;
import com.bishe.blood.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {
}
