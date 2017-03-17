package com.yao.dao.customerinfodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.entity.CustomerSource;
import com.yao.util.PageUtil;

public class SourceDao extends CommonDao{
	public List<CustomerSource> queryall() throws SQLException{
		String sql="select * from customer_source";
		List<CustomerSource> list=this.Query(sql);
		return list;
	}
	public List<CustomerSource> queryallPage(PageUtil p) throws SQLException{
		String sql="select * from customer_source limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerSource> list=this.Query(sql);
		return list;
	}
	public List<CustomerSource> queryByName(String name,PageUtil p) throws SQLException{
		String sql="select * from customer_source where source_name like '%"+name+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerSource> list=this.Query(sql);
		return list;
	}
	public int queryIdByName(String name) throws SQLException{
		String sql="select * from customer_source where source_name='"+name+"'";
		List<CustomerSource> list=this.Query(sql);
		if(list.size()!=0)
			return list.get(0).getSource_id();
		return 0;
	}
	public String queryNameById(int id) throws SQLException{
		String sql="select * from customer_source where source_id="+id;
		List<CustomerSource> list=this.Query(sql);
		if(list.size()!=0)
			return list.get(0).getSource_name();
		return "";
	}
	public int insert(CustomerSource c) throws SQLException{
		String sql="insert into customer_source values(null,'"+c.getSource_name()+"','1')";
		int i=this.update(sql);
		return i;
	}
	public int delete(int id) throws SQLException{
		String sql="delete from customer_source where source_id="+id;
		int i=this.update(sql);
		return i;
	}
	@Override
	public ArrayList<CustomerSource> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<CustomerSource> list=new ArrayList<CustomerSource>();
		while(rs.next()){
			CustomerSource cs=new CustomerSource();
			cs.setSource_id(rs.getInt(1));
			cs.setSource_name(rs.getString(2));
			cs.setIs_used(rs.getString(3));
			list.add(cs);
		}
		return list;
	}
}
