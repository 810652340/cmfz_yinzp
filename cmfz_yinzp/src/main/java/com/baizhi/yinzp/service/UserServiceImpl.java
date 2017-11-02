package com.baizhi.yinzp.service;

import com.baizhi.yinzp.annotation.LogAnnotation;
import com.baizhi.yinzp.dao.UserDAO;
import com.baizhi.yinzp.entity.CityFB;
import com.baizhi.yinzp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */
@Service("/userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> queryAll() {
        List<User> users = userDAO.queryAll();
        return users;
    }

    @Override
    @LogAnnotation(description = "修改用户状态")
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public Integer queryAc(Integer num) {
        Integer integers = userDAO.queryAc(num);
        return integers;
    }

    @Override
    public List<CityFB> queryCity() {
        List<CityFB> cityFBS = userDAO.queryCity();
        return cityFBS;
    }
}
