package com.bishe.blood.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bishe.blood.dao.UserDao;
import com.bishe.blood.entity.R;
import com.bishe.blood.entity.User;
import com.bishe.blood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public R verifyLogin(User user) {
        QueryWrapper<User> query = Wrappers.<User>query();
        query.eq("phone", user.getPhone());
        User db_user = userDao.selectOne(query);
        R r = new R();
        if (db_user == null){
            r.setCode(20001);
            r.setMsg("无此账户");
        }else if (!db_user.getPassword().equals(db_user.getPassword())){
            r.setCode(20001);
            r.setMsg("密码错误");
        } else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("token","user_" + db_user.getUserId());
            map.put("roles","user");
            map.put("username",db_user.getName());
            map.put("create_date",db_user.getCreateDate());
            map.put("update_date",db_user.getUpdateDate());
            r.setData(map);
        }
        return r;
    }
}
