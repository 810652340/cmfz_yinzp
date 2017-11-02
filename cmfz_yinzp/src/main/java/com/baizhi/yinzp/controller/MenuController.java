package com.baizhi.yinzp.controller;

import com.baizhi.yinzp.entity.Menu;
import com.baizhi.yinzp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Menu> all(){
        List<Menu> menus = menuService.queryAll();
        System.out.println("==============");
        System.out.println(menus);
        return menus;
    }
}
