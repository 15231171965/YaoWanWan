package com.yao.dao.userdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.entity.DepartmentInfo;
import com.yao.util.PageUtil;

public class DepartmentDao extends CommonDao{
	/*public static void main(String[] args) throws SQLException {
		DepartmentDao dd=new DepartmentDao();
		List<DepartmentInfo> list=dd.queryAll();//成功
		System.out.println(dd.queryNameById(1));//成功
		for (DepartmentInfo departmentInfo : list) {
			System.out.println(departmentInfo.getDepartment_name());
		}
	}*/
	public List<DepartmentInfo> queryAll() throws SQLException{
		String sql="select * from department_info";
		List<DepartmentInfo> list=this.Query(sql);
		return list;
	}
	public List<DepartmentInfo> queryAllPage(PageUtil p) throws SQLException{
		String sql="select * from department_info limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<DepartmentInfo> list=this.Query(sql);
		return list;
	}
	public List<DepartmentInfo> queryByName(String name,PageUtil p) throws SQLException{
		String sql="select * from department_info where department_name like '%"+name+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<DepartmentInfo> list=this.Query(sql);
		return list;
	}
	public int delete(int id)throws SQLException{
		String sql="delete from department_info where department_id="+id;
		int i=this.update(sql);
		return i;
	}
	public String queryNameById(int id) throws SQLException{
		String sql="select * from department_info where department_id="+id;
		List<DepartmentInfo> list=this.Query(sql);
		String name="";
		if(list!=null&&list.size()!=0){
			name=list.get(0).getDepartment_name();
		}
		return name;
	}
	public int queryIdByName(String name)throws SQLException{
		String sql="select * from department_info where department_name='"+name+"'";
		List<DepartmentInfo> list=this.Query(sql);
		int i=0;
		if(list!=null&&list.size()!=0){
			i=list.get(0).getDepartment_id();
		}
		return i;
	}
	public int insert(String name,String desc)throws SQLException{
		String sql="insert into department_info values(null,'"+name+"','"+desc+"','1')";
		int i=this.update(sql);
		return i;
	}
	@Override
	public  ArrayList<DepartmentInfo> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<DepartmentInfo> list=new ArrayList<DepartmentInfo>();
		while(rs.next()){
			DepartmentInfo d=new DepartmentInfo();
			d.setDepartment_id(rs.getInt(1));
			d.setDepartment_name(rs.getString(2));
			d.setDepartment_desc(rs.getString(3));
			d.setIs_used(rs.getString(4));
			list.add(d);
		}
		return list;
	}
	
}
