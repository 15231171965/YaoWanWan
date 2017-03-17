package com.yao.dao.commondao;
import com.yao.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public abstract class CommonDao {
	public int update(String sql,Object...objects) throws SQLException{
		Connection conn=null;
		try {
			conn = DBHelper.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement psmt = null;
		int j=0;
		try {
			psmt = conn.prepareStatement(sql);
			if(objects!=null)
				for(int i=0;i<objects.length;i++){
					psmt.setObject(i+1, objects[i]);
				}
			j=psmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.closeAll(conn, psmt, null);
		}
		return j;
	}
	public <T> List<T> Query(String sql,Object...objects) throws SQLException{
		Connection conn=null;
		try {
			conn = DBHelper.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement psmt=conn.prepareStatement(sql);
		ResultSet rs=null;
		List<T> list=null;
		try {
			if(objects!=null)
				for(int i=0;i<objects.length;i++){
					psmt.setObject(i+1, objects[i]);
				}
			rs=psmt.executeQuery();
			list=getList(rs);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBHelper.closeAll(conn, psmt, rs);
		}
		return list;
	}
	public abstract <T> ArrayList<T> getList(ResultSet rs) throws SQLException;
}
