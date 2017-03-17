package com.yao.dao.customerLinkRecordDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.entity.CustomerLinkrecord;
import com.yao.util.PageUtil;

public class CustomerLinkRecordDao extends CommonDao implements ICustomerLinkrecordDao {
	public static void main(String[] args) throws SQLException {
		CustomerLinkRecordDao clrd=new CustomerLinkRecordDao();
		//List<CustomerLinkrecord> list=clrd.queryall();//成功
		//List<CustomerLinkrecord> list=clrd.queryByCustomerName("李四");//根据客户名字查OK
		//List<CustomerLinkrecord> list=clrd.queryByTheme("过来买房");//根据联系主题查OK
		//List<CustomerLinkrecord> list=clrd.queryByType("打电话");//根据联系类型查OK
//		for (CustomerLinkrecord c : list) {
//			System.out.println(c.getLink_theme());
//		}
	}
	@Override
	public List<CustomerLinkrecord> queryall() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from customer_linkreord";
		List<CustomerLinkrecord> list=this.Query(sql);
		return list;
	}
	public List<CustomerLinkrecord> queryallPage(PageUtil p) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from customer_linkreord limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerLinkrecord> list=this.Query(sql);
		return list;
	}
	public List<CustomerLinkrecord> queryByCustomerName(String name,PageUtil p) throws SQLException{//根据客户名字查
//		CustomerInfoDao cd=new CustomerInfoDao();
//		int id=cd.queryIdByName(name);
		String sql="select * from customer_linkreord l,customer_info c where l.customer_id=c.customer_id and c.customer_name like '%"+name+"%'";
		//String sql="select * from customer_linkreord where customer_id="+id+" limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerLinkrecord> list=this.Query(sql);
		return list;
	}
	public List<CustomerLinkrecord> queryByTheme(String theme,PageUtil p) throws SQLException {//根据联系主题查
		// TODO Auto-generated method stub
		String sql="select * from customer_linkreord where link_theme like '%"+theme+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerLinkrecord> list=this.Query(sql);
		return list;
	}
	public List<CustomerLinkrecord> queryByType(String type,PageUtil p) throws SQLException {//根据联系主题查
		// TODO Auto-generated method stub
		String sql="select * from customer_linkreord where link_type like '%"+type+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerLinkrecord> list=this.Query(sql);
		return list;
	}
	public List<CustomerLinkrecord> remind(int i) throws SQLException{
		String sql="select * from customer_linkreord where UNIX_TIMESTAMP(link_nexttime)-UNIX_TIMESTAMP(now())<"+i+"*86400"
				+ "&&UNIX_TIMESTAMP(link_nexttime)-UNIX_TIMESTAMP(now())>0";
		List<CustomerLinkrecord> list=this.Query(sql);
		return list;
	}
	public int insert(CustomerLinkrecord c)throws SQLException{
		String sql="insert into customer_linkreord values(null,?,?,?,?,?,?,?,'1')";
		int i=this.update(sql, c.getCustomer_id(),c.getLink_time(),c.getWho_link(),c.getLink_type(),c.getLink_theme(),c.getLink_nexttime(),c.getLink_remark());
		return i;
	}
	public int delete(int id)throws SQLException{
		String sql="delete from customer_linkreord where record_id="+id;
		int i=this.update(sql);
		return i;
	}
	@Override
	public ArrayList<CustomerLinkrecord> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<CustomerLinkrecord> list=new ArrayList<CustomerLinkrecord>();
		CustomerInfoDao cid=new CustomerInfoDao();
		while(rs.next()){
			CustomerLinkrecord c=new CustomerLinkrecord();
			c.setRecord_id(rs.getInt(1));
			c.setCustomer_name(cid.queryNameById(rs.getInt(2)));
			c.setCustomer_id(rs.getInt(2));
			c.setLink_time(rs.getTimestamp(3));
			c.setWho_link(rs.getString(4));
			c.setLink_type(rs.getString(5));
			c.setLink_theme(rs.getString(6));
			c.setLink_nexttime(rs.getTimestamp(7));
			c.setLink_remark(rs.getString(8));
			c.setIs_used(rs.getString(9));
			list.add(c);
		}
		return list;
	}
	
}
