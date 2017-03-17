package com.yao.dao.customerlinkmandao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.entity.CustomerLinkman;
import com.yao.util.PageUtil;

public class LinkManDao extends CommonDao {
	/*
	 * public static void main(String[] args) throws SQLException { LinkManDao
	 * lmd=new LinkManDao(); //List<CustomerLinkman> list=lmd.queryAll();//成功
	 * //List<CustomerLinkman> list=lmd.queryByCustomerName("吴天");//成功
	 * List<CustomerLinkman> list=lmd.queryByLinkManName("小李");//成功 for
	 * (CustomerLinkman customerLinkman : list) {
	 * System.out.println(customerLinkman.getCustomer_name()); } }
	 */
	public List<CustomerLinkman> queryAll() throws SQLException {
		String sql = "select * from customer_linkman";
		List<CustomerLinkman> list = this.Query(sql);
		return list;
	}
	public List<CustomerLinkman> queryAllPage(PageUtil p) throws SQLException {
		String sql = "select * from customer_linkman limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerLinkman> list = this.Query(sql);
		return list;
	}

	public List<CustomerLinkman> queryByLinkManName(String name,PageUtil p) throws SQLException {
		String sql = "select * from customer_linkman where linkman_name like '%" + name + "%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerLinkman> list = this.Query(sql);
		return list;
	}

	public List<CustomerLinkman> queryByCustomerName(String name,PageUtil p) throws SQLException {
		//CustomerInfoDao cid = new CustomerInfoDao();
		//int id = cid.queryIdByName(name);
		//String sql = "select * from customer_linkman where customer_id=" + id+" limit "+(p.getFirst()-1)+","+p.getPagesize();
		String sql="select * from customer_linkman l,customer_info c where l.customer_id=c.customer_id and c.customer_name like '%"+name+"%'";
		List<CustomerLinkman> list = this.Query(sql);
		return list;
	}

	public CustomerLinkman queryById(int id) throws SQLException {
		String sql = "select * from customer_linkman where linkman_id=" + id;
		List<CustomerLinkman> list = this.Query(sql);
		if (list != null && list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

	public int insert(CustomerLinkman c) throws SQLException {
		String sql = "insert into customer_linkman values(null,?,?,?,?,?,?,?,'1')";
		int i = this.update(sql, c.getCustomer_id(), c.getLinkman_name(), c.getLinkman_sex(), c.getLinkman_job(),
				c.getLinkman_mobile(), c.getLinkman_age(), c.getLinkman_relation());
		return i;
	}

	public int delete(int id) throws SQLException {
		String sql = "delete from customer_linkman where linkman_id=" + id;
		int i = this.update(sql);
		return i;
	}

	public int update(CustomerLinkman c) throws SQLException {
		String sql = "update customer_linkman set customer_id=?,linkman_name=?,linkman_sex=?"
				+ ",linkman_job=?,linkman_mobile=?,linkman_age=?,linkman_relation=? where linkman_id=?";
		int i = this.update(sql, c.getCustomer_id(), c.getLinkman_name(), c.getLinkman_sex(), c.getLinkman_job(),
				c.getLinkman_mobile(), c.getLinkman_age(), c.getLinkman_relation(), c.getLinkman_id());
		return i;
	}

	@Override
	public ArrayList<CustomerLinkman> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<CustomerLinkman> list = new ArrayList<CustomerLinkman>();
		CustomerInfoDao cid = new CustomerInfoDao();
		while (rs.next()) {
			CustomerLinkman c = new CustomerLinkman();
			c.setLinkman_id(rs.getInt(1));
			c.setCustomer_id(rs.getInt(2));
			c.setCustomer_name(cid.queryNameById(rs.getInt(2)));
			c.setLinkman_name(rs.getString(3));
			c.setLinkman_sex(rs.getString(4));
			c.setLinkman_job(rs.getString(5));
			c.setLinkman_mobile(rs.getString(6));
			c.setLinkman_age(rs.getInt(7));
			c.setLinkman_relation(rs.getString(8));
			c.setIs_used(rs.getString(9));
			list.add(c);
		}
		return list;
	}

}
