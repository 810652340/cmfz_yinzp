package com.baizhi.yinzp.test;

import com.baizhi.yinzp.entity.Menu;
import com.baizhi.yinzp.service.MenuService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public class TestMenu {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        MenuService menuService = (MenuService)context.getBean("menuService");
        List<Menu> menus = menuService.queryAll();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
}
