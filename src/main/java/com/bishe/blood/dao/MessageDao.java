package com.bishe.blood.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.blood.entity.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends BaseMapper<Message> {
}
