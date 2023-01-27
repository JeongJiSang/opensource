package com.jbground.source.database.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcCommonFactory {
	
	private final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String _URL    = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private final static String _USER    = "jsjeong";
	private final static String _PW    = "jsjeong";
	
	private static Connection conn;
	
	public static Connection getInstance() {
		if(conn == null) {
			synchronized (Connection.class) {
				if(conn==null) {
					try {
						Class.forName(_DRIVER);
						conn = DriverManager.getConnection(_URL, _USER, _PW);
						/* 트랜잭션처리
						con.setAutoCommit(true);//켜둔다.
						con.setAutoCommit(false);//꺼둔다.
						con.commit();
						con.rollback();
						*/
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}
}
