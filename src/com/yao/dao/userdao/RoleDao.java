package com.yao.dao.userdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.entity.UserRole;
import com.yao.util.PageUtil;

public class RoleDao extends CommonDao {
	/*public static void main(String[] args) throws SQLException {
		RoleDao rd = new RoleDao();
		List<UserRole> list = rd.queryAll();// 成功
		System.out.println(rd.queryNameById(1));// 成功
		for (UserRole userRole : list) {
			System.out.println(userRole.getRole_name());
		}
	}*/

	public List<UserRole> queryAll() throws SQLException {
		String sql = "select * from user_role";
		List<UserRole> list = this.Query(sql);
		return list;
	}
	public List<UserRole> queryAllPage(PageUtil p) throws SQLException {
		String sql = "select * from user_role limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<UserRole> list = this.Query(sql);
		return list;
	}
	public List<UserRole> queryByName(String name,PageUtil p) throws SQLException{
		String sql="select * from user_role where role_name like '%"+name+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<UserRole> list=this.Query(sql);
		return list;
	}
	public String queryNameById(int id) throws SQLException {
		String name = "";
		String sql = "select * from user_role where role_id=" + id;
		List<UserRole> list = this.Query(sql);
		if (list != null && list.size() != 0) {
			name = list.get(0).getRole_name();
		}
		return name;
	}
	public int queryIdByName(String name) throws SQLException {
		int id=0;
		String sql = "select * from user_role where role_name='"+name+"'";
		List<UserRole> list = this.Query(sql);
		if (list != null && list.size() != 0) {
			id=list.get(0).getRole_id();
		}
		return id;
	}
	public int insert(String name,String power)throws SQLException{
		String sql="insert into user_role values(null,'"+name+"','"+power+"','1')";
		int i=this.update(sql);
		return i;
	}
	public int delete(int id)throws SQLException{
		String sql="delete from user_role where role_id="+id;
		int i=this.update(sql);
		return i;
	}
	@Override
	public ArrayList<UserRole> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<UserRole> list = new ArrayList<UserRole>();
		while (rs.next()) {
			UserRole u = new UserRole();
			u.setRole_id(rs.getInt(1));
			u.setRole_name(rs.getString(2));
			u.setRole_power(rs.getString(3));
			u.setIs_used(rs.getString(4));
			list.add(u);
		}
		return list;
	}

}
