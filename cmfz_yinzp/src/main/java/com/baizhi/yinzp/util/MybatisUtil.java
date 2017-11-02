package com.baizhi.yinzp.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 对sqlSession方法进行封装
 * 
 * */
public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	private static final ThreadLocal<SqlSession> thr=new ThreadLocal<SqlSession>();
	static{	
		try {
			//加载主配置文件
			InputStream	 resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
			//创建sqlSessionfactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/*
	 * 提供一个静态方法对sqlSession 进行封装
	 * */
	public static SqlSession getSqlSession(){
		SqlSession sqlSession=thr.get();
		if(sqlSession==null){
			sqlSession = sqlSessionFactory.openSession();
			thr.set(sqlSession);
		}	
		return sqlSession;
	} 	
	public static void closeSqlSession(){
		SqlSession sqlSession=thr.get();
		if(sqlSession!=null){
			sqlSession.close();
			thr.remove();
		}
	}
}