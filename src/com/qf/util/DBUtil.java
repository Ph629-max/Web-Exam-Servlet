package com.qf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 数据库工具类 - 使用 try-with-resources 自动管理连接
 */
public class DBUtil {
	
	// 数据库配置（生产环境请移入配置文件）
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "123456";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 关闭连接资源（安全关闭，可传入 null）
	 */
	public static void close(AutoCloseable... resources) {
		for (AutoCloseable res : resources) {
			if (res != null) {
				try {
					res.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 关闭 Connection + Statement + ResultSet（重载，兼容旧用法）
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		close(rs, stmt, conn);
	}
}
