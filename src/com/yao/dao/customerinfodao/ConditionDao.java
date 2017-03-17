package com.yao.dao.customerinfodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.entity.CustomerCondition;
import com.yao.entity.CustomerSource;
import com.yao.util.PageUtil;

public class ConditionDao extends CommonDao implements IConditionDao{
	public List<CustomerCondition> queryall() throws SQLException{
		String sql="select * from customer_condition";
		List<CustomerCondition> list=this.Query(sql);
		return list;
	}
	public List<CustomerCondition> queryallPage(PageUtil p) throws SQLException{
		String sql="select * from customer_condition limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerCondition> list=this.Query(sql);
		return list;
	}
	public int queryIdByName(String name)throws SQLException{
		String sql="select * from customer_condition where condition_name='"+name+"'";
		List<CustomerCondition> list=this.Query(sql);
		if(list.size()!=0){
			return list.get(0).getCondition_id();
		}
		return 0;
	}
	public String queryNameById(int id)throws SQLException{
		String sql="select * from customer_condition where condition_id="+id;
		List<CustomerCondition> list=this.Query(sql);
		if(list.size()!=0){
			return list.get(0).getCondition_name();
		}
		return "";
	}
	public List<CustomerCondition> queryByName(String name,PageUtil p) throws SQLException{
		String sql="select * from customer_condition where condition_name like '%"+name+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerCondition> list=this.Query(sql);
		return list;
	}
	public int insert(CustomerCondition c)throws SQLException{
		String sql="insert into customer_condition values(null,?,?,'1')";
		int i=this.update(sql,c.getCondition_name(),c.getCondition_explain());
		return i;
	}
	public int delete(int id)throws SQLException{
		String sql="delete from customer_condition where condition_id="+id;
		int i=this.update(sql);
		return i;
	}
	@Override
	public ArrayList<CustomerCondition> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<CustomerCondition> list=new ArrayList<CustomerCondition>();
		while(rs.next()){
			CustomerCondition c=new CustomerCondition();
			c.setCondition_id(rs.getInt(1));
			c.setCondition_name(rs.getString(2));
			c.setCondition_explain(rs.getString(3));
			c.setIs_used(rs.getString(4));
			list.add(c);
		}
		return list;
	}
}
