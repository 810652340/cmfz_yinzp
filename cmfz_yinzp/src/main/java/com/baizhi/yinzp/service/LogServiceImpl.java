package com.baizhi.yinzp.service;

import com.baizhi.yinzp.dao.LogDAO;
import com.baizhi.yinzp.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/31.
 */
@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDAO logDAO;
    @Override
    @Transactional
    public void save(Log log) {
        log.setId(UUID.randomUUID().toString());
        logDAO.save(log);
    }

    @Override
    public List<Log> queryAll() {
        List<Log> logs = logDAO.queryAll();
        return logs;
    }
}
