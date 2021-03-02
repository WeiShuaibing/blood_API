package com.bishe.blood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.blood.entity.Admin;
import com.bishe.blood.entity.Thank;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ThankDao extends BaseMapper<Thank> {

    @Update("update thank set status = #{status} where user_id = #{user_id}")
    public int updateStatus(int user_id, int status);

}
