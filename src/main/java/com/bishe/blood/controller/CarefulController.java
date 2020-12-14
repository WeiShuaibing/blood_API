package com.bishe.blood.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bishe.blood.entity.Careful;
import com.bishe.blood.entity.Message;
import com.bishe.blood.entity.R;
import com.bishe.blood.service.CarefulService;
import com.bishe.blood.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 注意事项控制层
 */

@RestController
@RequestMapping("/careful")
public class CarefulController {

    @Autowired
    private CarefulService carefulService;

    @PostMapping("/save")
    public R save(@RequestBody Careful careful){
        boolean b = carefulService.saveOrUpdate(careful);
        if (b) {
            return new R();
        } else {
            return new R(20001,"服务异常，保存失败！");
        }
    }

    @GetMapping("/deleteById")
    public R deleteById(int id){
        boolean b = carefulService.removeById(id);
        if (b) {
            return new R();
        } else {
            return new R(20001,"服务异常，删除失败！");
        }
    }

    @GetMapping("/getPage")
    public R getPage(int pageNum, int pageSize) {
        Page<Careful> messagePage = new Page<>(pageNum, pageSize);
        QueryWrapper<Careful> query = Wrappers.<Careful>query();
        query.orderByDesc("id");
        Page<Careful> page = carefulService.page(messagePage, query);
        return new R(page);
    }

}
