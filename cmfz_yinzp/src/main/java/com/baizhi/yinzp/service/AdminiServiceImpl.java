package com.baizhi.yinzp.service;

import com.baizhi.yinzp.dao.AdminiDAO;
import com.baizhi.yinzp.entity.Admini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/25.
 */
@Service("adminiService")
@Transactional
public class AdminiServiceImpl implements AdminiService {
    @Autowired
    private AdminiDAO adminiDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admini queryByName(String name) {
        Admini admini = adminiDAO.queryByName(name);
        return admini;
    }

    @Override

    public void update(Admini admini) {
        adminiDAO.update(admini);
    }
}
