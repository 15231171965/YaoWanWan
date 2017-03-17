package com.yao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	private static DataSource dataSource=new DataSource();
	public static Connection getConnection(){
		return dataSource.getConnection();
	}
	public static void closeAll(Connection conn,Statement smt,ResultSet rs){
		if(conn!=null)
			dataSource.close(conn);
		if(smt!=null){
			try {
				smt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Connection conn=getConnection();
		System.out.println(conn);
	}
}
