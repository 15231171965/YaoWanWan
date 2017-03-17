package com.yao.dao.baobiaodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.customerinfodao.ConditionDao;
import com.yao.entity.ConditionNum;

public class ConditionNumDao extends CommonDao{
	/*public static void main(String[] args) throws SQLException {
		ConditionNumDao c=new ConditionNumDao();
		List<ConditionNum> list=c.queryAll();
		for (ConditionNum conditionNum : list) {
			System.out.println(conditionNum);
		}
	}*/
	public List<ConditionNum> queryAll() throws SQLException{
		String sql="select distinct condition_id from customer_info where condition_id is not null";
		List<ConditionNum> list=this.Query(sql);
		return list;
	}
	@Override
	public ArrayList<ConditionNum> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<ConditionNum> list=new ArrayList<ConditionNum>();
		ConditionDao conddao=new ConditionDao();
		CountDao cd=new CountDao();
		while(rs.next()){
			ConditionNum c=new ConditionNum();
			c.setCondition_id(rs.getInt(1));
			c.setCondition_name(conddao.queryNameById(rs.getInt(1)));
			c.setNum(cd.queryByFlag("condition_id="+rs.getInt(1)));
			list.add(c);
		}
		return list;
	}
	
}
