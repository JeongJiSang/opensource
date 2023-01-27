package com.jbground.source.database.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisCommonFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
	
	public static SqlSessionFactory getInstance() {
		if(sqlSessionFactory == null) {
			synchronized (SqlSessionFactory.class) {
				//동기화 블럭에 들어온 후에도 다시한번 널 체크
				if(sqlSessionFactory == null) {
					try {
						Reader reader = Resources.getResourceAsReader("META-INF/mybatis/Configuration.xml");
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return sqlSessionFactory;
	}
}
