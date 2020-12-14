package com.bishe.blood.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bishe.blood.entity.Admin;
import com.bishe.blood.entity.Message;
import com.bishe.blood.entity.R;
import com.bishe.blood.service.AdminService;
import com.bishe.blood.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公告控制层
 */

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/save")
    public R save(@RequestBody Message message){
        boolean b = messageService.saveOrUpdate(message);
        if (b) {
            return new R();
        } else {
            return new R(20001,"服务异常，保存失败！");
        }
    }

    @GetMapping("/deleteById")
    public R deleteById(int id){
        boolean b = messageService.removeById(id);
        if (b) {
            return new R();
        } else {
            return new R(20001,"服务异常，删除失败！");
        }
    }

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize) {
        Page<Message> messagePage = new Page<>(pageNum, pageSize);
        QueryWrapper<Message> query = Wrappers.<Message>query();
        query.orderByDesc("id");
        Page<Message> page = messageService.page(messagePage, query);
        return new R(page);
    }

}
