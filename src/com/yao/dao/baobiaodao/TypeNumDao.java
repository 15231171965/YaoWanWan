package com.yao.dao.baobiaodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.customerinfodao.TypeDao;
import com.yao.entity.TypeNum;

public class TypeNumDao extends CommonDao{
	/*public static void main(String[] args) throws SQLException {
		TypeNumDao td=new TypeNumDao();
		List<TypeNum> list=td.queryAll();
		System.out.println(list==null);
		for (TypeNum typeNum : list) {
			System.out.println(typeNum);
		}
	}*/
	public List<TypeNum> queryAll() throws SQLException{
		String sql="select distinct type_id from customer_info where type_id is not null";
		List<TypeNum> list=this.Query(sql);
		return list;
	}
	@Override
	public ArrayList<TypeNum> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<TypeNum> list=new ArrayList<TypeNum>();
		TypeDao td=new TypeDao();
		CountDao cd=new CountDao();
		while(rs.next()){
			TypeNum t=new TypeNum();
			t.setType_id(rs.getInt(1));
			t.setType_name(td.queryNameById(rs.getInt(1)));
			t.setType_num(cd.queryByFlag("type_id="+rs.getInt(1)));
			list.add(t);
		}
		return list;
	}
	
}
