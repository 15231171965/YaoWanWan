package com.yao.dao.pagedao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yao.dao.commondao.CommonDao;

public class PageDao extends CommonDao implements IPageDao{

	@Override
	public int getAll(String databasename) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select count(*) from "+databasename;
		int i=(int) this.Query(sql).get(0);
		return i;
	}

	@Override
	public  ArrayList<Integer> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(rs.next()){
			list.add(rs.getInt(1));
		}
		return list;
	}
	
}
