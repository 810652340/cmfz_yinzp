package com.baizhi.yinzp.controller;

import com.baizhi.yinzp.entity.Log;
import com.baizhi.yinzp.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;
    @RequestMapping("/all")
    @ResponseBody
    public List<Log> queryAll(){
        List<Log> logs = logService.queryAll();
        return  logs;
    }
}
