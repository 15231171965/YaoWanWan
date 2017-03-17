package com.yao.dao.baobiaodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.FenPeiNum;
import com.yao.entity.SourceNum;

public class FenPeiNumDao extends CommonDao{
	public static void main(String[] args) throws SQLException {
		FenPeiNumDao f=new FenPeiNumDao();
		List<FenPeiNum> list=f.queryAll();
		for (FenPeiNum fenPeiNum : list) {
			System.out.println(fenPeiNum);
		}
	}
	public List<FenPeiNum> queryAll() throws SQLException{
		String sql="select user_id from customer_info where user_id is null";
		List<FenPeiNum> list=this.Query(sql);
		return list;
	}
	@Override
	public ArrayList<FenPeiNum> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<FenPeiNum> list=new ArrayList<FenPeiNum>();
		UserDao ud=new UserDao();
		CountDao cd=new CountDao();
		while(rs.next()){
			FenPeiNum f=new FenPeiNum();
			f.setUser_id(rs.getInt(1));
			f.setUser_name(ud.queryNameById(rs.getInt(1)));
			f.setNum(cd.queryByFlag("user_id="+rs.getInt(1)));
			list.add(f);
		}
		return list;
	}
	
}
