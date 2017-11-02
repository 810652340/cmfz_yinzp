package com.baizhi.yinzp.service;

import com.baizhi.yinzp.dao.MenuDAO;
import com.baizhi.yinzp.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;
    @Override
    public List<Menu> queryAll() {
        List<Menu> menus = menuDAO.queryAll();
        return menus;
    }
}
