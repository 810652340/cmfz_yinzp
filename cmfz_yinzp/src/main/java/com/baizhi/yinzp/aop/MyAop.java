package com.baizhi.yinzp.aop;

import com.baizhi.yinzp.annotation.LogAnnotation;
import com.baizhi.yinzp.entity.Admini;
import com.baizhi.yinzp.entity.Log;
import com.baizhi.yinzp.service.LogService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/31.
 */
@Component
public class MyAop implements MethodInterceptor{
    @Autowired
    private LogService logService;
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Log log =new Log();
        Date date = new Date();
        System.out.println("====================进来了=====================");
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Admini name = (Admini) session.getAttribute("name");
        LogAnnotation annotation = invocation.getMethod().getAnnotation(LogAnnotation.class);
        log.setDoSomething(annotation.description());
        log.setUsername(name.getName());
        log.setDate(date);
        Object proceed=null;
        try {
            proceed = invocation.proceed();
            //记录操作成功
            log.setStatus("成功");
        } catch (Exception e) {
            //记录操作失败
            log.setStatus("失败");
        }
        logService.save(log);
        return proceed;
    }
}
