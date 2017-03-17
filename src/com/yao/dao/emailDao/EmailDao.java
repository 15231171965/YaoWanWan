package com.yao.dao.emailDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.EmailInfo;
import com.yao.util.PageUtil;

public class EmailDao extends CommonDao{
	public List<EmailInfo> queryAll()throws SQLException{
		String sql="select * from email_info";
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	
	public List<EmailInfo> queryAllByFa(int userId,PageUtil p)throws SQLException{
		String sql="select * from email_info where user_id="+userId+" and email_state='1' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	public List<EmailInfo> queryAllByCao(int userId,PageUtil p)throws SQLException{
		String sql="select * from email_info where user_id="+userId+" and email_state='0' limit "+(p.getFirst()-1)+","+p.getPagesize();;
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	
	public List<EmailInfo> queryAllByShou(int userId)throws SQLException{
		String sql="select * from email_info where user_id="+userId+" and email_state='0'";
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	
	public List<EmailInfo> queryByShouJianRen(int userId,String name,PageUtil p)throws SQLException{//根据收件人查已发邮件
		CustomerInfoDao cd=new CustomerInfoDao();
		int cid=cd.queryIdByName(name);
		String sql="select * from email_info where user_id="+userId+" and email_state='1' and customer_id="+cid+" limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	public List<EmailInfo> queryCaoGaoByShouJianRen(int userId,String name)throws SQLException{//根据收件人查草稿邮件
		CustomerInfoDao cd=new CustomerInfoDao();
		int cid=cd.queryIdByName(name);
		String sql="select * from email_info where user_id="+userId+" and email_state='0' and customer_id="+cid;
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	
	
	public List<EmailInfo> queryByNeiRong(int userId,String neirong)throws SQLException{//根据内容查已发邮件
		String sql="select * from email_info where user_id="+userId+" and email_state='1' and email_content='"+neirong+"'";
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	public List<EmailInfo> queryCaoGaoByNeiRong(int userId,String neirong)throws SQLException{//根据内容查草稿邮件
		String sql="select * from email_info where user_id="+userId+" and email_state='0' and email_content='"+neirong+"'";
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	
	
	public List<EmailInfo> queryByTheme(int userId,String theme)throws SQLException{//根据主题查已发邮件
		String sql="select * from email_info where user_id="+userId+" and email_state='1' and email_theme='"+theme+"'";
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	public List<EmailInfo> queryCaoGaoByTheme(int userId,String theme)throws SQLException{//根据主题查草稿邮件
		String sql="select * from email_info where user_id="+userId+" and email_state='0' and email_theme='"+theme+"'";
		List<EmailInfo> list=this.Query(sql);
		return list;
	}
	
	
	public int insert(EmailInfo e)throws SQLException{
		String sql="insert into email_info values(null,?,?,?,?,'1',?,'1')";
		int i=this.update(sql, e.getCustomer_id(),e.getUser_id(),e.getEmail_content(),e.getEmail_time(),e.getEmail_theme());
		return i;
	}
	public int caogao(EmailInfo e)throws SQLException{//草稿
		String sql="insert into email_info values(null,?,?,?,?,'0',?,'1')";
		int i=this.update(sql, e.getCustomer_id(),e.getUser_id(),e.getEmail_content(),e.getEmail_time(),e.getEmail_theme());
		return i;
	}
	public int delete(int id) throws SQLException{
		String sql="delete from email_info where email_id="+id;
		int i=this.update(sql);
		return i;
	}
	public int send(int id)throws SQLException{
		String sql="update email_info set email_state='1' where email_id="+id;
		int i=this.update(sql);
		return i;
	}
	
	@Override
	public ArrayList<EmailInfo> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<EmailInfo> list=new ArrayList<EmailInfo>();
		UserDao ud=new UserDao();
		CustomerInfoDao cd=new CustomerInfoDao();
		while(rs.next()){
			EmailInfo e=new EmailInfo();
			e.setEmail_id(rs.getInt(1));
			e.setCustomer_id(rs.getInt(2));
			e.setCustomer_name(cd.queryNameById(rs.getInt(2)));
			e.setUser_id(rs.getInt(3));
			e.setUser_name(ud.queryNameById(rs.getInt(3)));
			e.setEmail_content(rs.getString(4));
			e.setEmail_time(rs.getTimestamp(5));
			e.setEmail_state(rs.getString(6));
			e.setEmail_theme(rs.getString(7));
			e.setIs_used(rs.getString(8));
			list.add(e);
		}
		return list;
	}
	
}
