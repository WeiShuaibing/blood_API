package com.bishe.blood.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bishe.blood.dao.AdminDao;
import com.bishe.blood.dao.MessageDao;
import com.bishe.blood.entity.Admin;
import com.bishe.blood.entity.Message;
import com.bishe.blood.entity.R;
import com.bishe.blood.service.AdminService;
import com.bishe.blood.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {

}
