package com.yao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class DataSource {// 数据连接池
	private static LinkedList<Connection> connectionPool = new LinkedList<Connection>();// 创建一个连接池
	private static final String driver = Reader.getReader().getProperty("driver");
	private static final String url = Reader.getReader().getProperty("url");
	private static final String username = Reader.getReader().getProperty("username");
	private static final String password = Reader.getReader().getProperty("password");
	private int initCount = 5;// 连接池初始数量
	private int maxCount = 100;// 数据库最大链接数量
	private int currentCount = 0;// 链接数量

	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("加载驱动成功");
	}

	public DataSource() {// 初始化
		for (int i = 0; i < initCount; i++) {
			connectionPool.add(createConnection());
		}
	}

	public Connection getConnection() {
		synchronized (connectionPool) {
			if(connectionPool.size()>0)
				return connectionPool.removeLast();
			if(currentCount<maxCount)
				return createConnection();
			try {
				throw new Exception("链接数量过多");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

	}

	public void close(Connection conn) {
		connectionPool.addFirst(conn);
	}

	public Connection createConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentCount++;
		return conn;
	}

}
