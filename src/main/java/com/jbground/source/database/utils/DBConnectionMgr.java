package com.jbground.source.database.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnectionMgr {
	
	private final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String _URL    = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private final static String _USER    = "jsjeong";
	private final static String _PW    = "jsjeong";

	static DBConnectionMgr dbcon = null;
	Connection conn = null;
	
	public static DBConnectionMgr getInstance() {
		if(dbcon == null) {
			dbcon = new DBConnectionMgr();
		}
		return dbcon;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(_DRIVER);
			conn = DriverManager.getConnection(_URL, _USER, _PW);
			/* 트랜잭션처리
			con.setAutoCommit(true);//켜둔다.
			con.setAutoCommit(false);//꺼둔다.
			con.commit();
			con.rollback();
			*/
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 찾을 수 없습니다.");
		} catch (Exception e) {
			System.out.println("오라클 서버와 연결 실패!!!.");
		}
		return conn;
	}
	//사용한 자원 반납하기
	//이것을 하지 않으면 오라클 서버에 접속할 때 세션 수의 제한 때문에 오라클서버를 재기동해야 할 수도 있음.
	public void freeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs !=null) rs.close();
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//rs 없는 자원반납
	public void freeConnection(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection conn, CallableStatement cstmt, ResultSet rs) {
		try {
			if(rs !=null) rs.close();
			if(cstmt !=null) cstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void freeConnection(Connection conn, CallableStatement cstmt) {
		try {
			if(cstmt !=null) cstmt.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}