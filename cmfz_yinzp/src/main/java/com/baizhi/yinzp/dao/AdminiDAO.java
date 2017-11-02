package com.baizhi.yinzp.dao;

import com.baizhi.yinzp.entity.Admini;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface AdminiDAO {
//    管理员登录
    public Admini queryByName(String name);
//    修改密码
    public void update(Admini admini);

}
