package com.qf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 数据库工具类 - 使用 try-with-resources 自动管理连接
 *
 * 连接信息优先从环境变量 / JVM 系统属性读取，未配置时回落到下面的占位值。
 * 请勿把真实口令写死后提交到公开仓库。
 */
public class DBUtil {

	// 未配置时使用的默认值（占位，运行前请通过环境变量覆盖）
	private static final String DB_URL = getConfig("DB_URL",
			"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
	private static final String DB_USER = getConfig("DB_USER", "your_username");
	private static final String DB_PASSWORD = getConfig("DB_PASSWORD", "your_password");

	private static String getConfig(String key, String defaultValue) {
		String value = System.getProperty(key);
		if (value == null || value.isEmpty()) {
			value = System.getenv(key);
		}
		return (value == null || value.isEmpty()) ? defaultValue : value;
	}

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
