package com.yao.dao.customerinfodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.entity.CustomerSource;
import com.yao.entity.CustomerType;
import com.yao.util.PageUtil;

public class TypeDao extends CommonDao{
	public List<CustomerType> queryall() throws SQLException{//查所有
		String sql="select * from customer_type";
		List<CustomerType> list=this.Query(sql);
		return list;
	}
	public List<CustomerType> queryallPage(PageUtil p) throws SQLException{//查所有
		String sql="select * from customer_type limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerType> list=this.Query(sql);
		return list;
	}
	public CustomerType queryById(int id)throws SQLException{
		String sql="select * from customer_type where type_id="+id;
		List<CustomerType> list=this.Query(sql);
		if(list.size()>0&&list!=null){
			return list.get(0);
		}
		return null;
	}
	public List<CustomerType> queryByName(String name,PageUtil p) throws SQLException{//根据名字查Type
		String sql="select * from customer_type where type_name like '%"+name+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerType> list=this.Query(sql);
		return list;
	}
	public int queryIdByName( String name) throws SQLException{//根据名字查ID
		String sql="select * from customer_type where type_name='"+name+"'";
		List<CustomerType> list=this.Query(sql);
		if(list.size()!=0)
			return list.get(0).getType_id();
		return 0;
	}
	public String queryNameById( int id) throws SQLException{//根据ID查名字
		String sql="select * from customer_type where type_id="+id;
		List<CustomerType> list=this.Query(sql);
		if(list.size()!=0)
			return list.get(0).getType_name();
		return "";
	}
	public int insert(String typeName)throws SQLException{// 添加类型
		String sql="insert into customer_type values(null,'"+typeName+"','1')";
		int i=this.update(sql);
		return i;
	}
	public int update(CustomerType type) throws SQLException{//修改类型
		String sql="update customer_type set type_name='"+type.getType_name()+"',is_used='"+type.getIs_used()+"' where type_id="+type.getType_id();
		int i=this.update(sql);
		return i;
	}
	public int delete(int id)throws SQLException{//删除类型
		String sql="delete from customer_type where type_id="+id;
		int i=this.update(sql);
		return i;
	}
	@Override
	public ArrayList<CustomerType> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<CustomerType> list=new ArrayList<CustomerType>();
		while(rs.next()){
			CustomerType ts=new CustomerType();
			ts.setType_id(rs.getInt(1));
			ts.setType_name(rs.getString(2));
			ts.setIs_used(rs.getString(3));
			list.add(ts);
		}
		return list;
	}
}
