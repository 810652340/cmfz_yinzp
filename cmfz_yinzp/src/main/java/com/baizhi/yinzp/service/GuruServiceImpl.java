package com.baizhi.yinzp.service;

import com.baizhi.yinzp.annotation.LogAnnotation;
import com.baizhi.yinzp.dao.GuruDAO;
import com.baizhi.yinzp.entity.Guru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
@Service("guruService")
@Transactional
public class GuruServiceImpl implements GuruService {
    @Autowired
    private GuruDAO guruDAO;
//    查看所有的上师
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Guru> queryAll() {
        List<Guru> gurus = guruDAO.queryAll();
        return gurus;
    }
//    添加一个上师
    @Override
    @LogAnnotation(description = "添加上师")
    public void save(Guru guru) {
        guruDAO.save(guru);
    }
//    修改上师的状态
    @Override
    @LogAnnotation(description = "修改上师的状态")
    public void update(Guru guru) {
        guruDAO.update(guru);
    }

    @Override
    public List<Guru> queryOne() {
        List<Guru> gurus = guruDAO.queryAllone();
        return gurus;
    }
}
