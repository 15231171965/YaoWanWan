package com.yao.dao.baobiaodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.entity.Count;

public class CountDao extends CommonDao{
	
	public int queryByFlag(String flag) throws SQLException{
		String sql="select count(*) from customer_info where "+flag;
		List<Count> list=this.Query(sql);
		return list.get(0).getCount();
	}
	@Override
	public ArrayList<Count> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Count> list=new ArrayList<Count>();
		while(rs.next()){
			Count c=new Count();
			c.setCount(rs.getInt(1));
			list.add(c);
		}
		return list;
	}
	
}
