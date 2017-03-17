package com.yao.dao.userdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.entity.CustomerCondition;
import com.yao.entity.CustomerInfo;
import com.yao.entity.UserInfo;
import com.yao.util.PageUtil;

public class UserDao extends CommonDao implements IUserDao{
	/*public static void main(String[] args) throws SQLException {
		UserDao ud=new UserDao();
		List<UserInfo> list=ud.queryAll();//正常
		//List<UserInfo> list=ud.queryByNamePwd("456", "456");//正常
		for (UserInfo userInfo : list) {
			System.out.println(userInfo.getDepartment_name());
		}
		UserInfo user=new UserInfo(3,1,"湾湾","男","15231171965",21,"石家庄","yao","123456"
				,"8087948","130182199601260319","344922690@qq.com",new Timestamp(new Date().getTime()),"姚",new Timestamp(new Date().getTime())
				,"未修改","很多很多","本科","2323232345555555522","汉","已婚","1");
		int i=ud.delete(user);
		System.out.println(i);
	}*/
	@Override
	public List<UserInfo> queryAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from user_info";
		List<UserInfo> list=this.Query(sql);
		return list;
	}
	public List<UserInfo> queryAllPage(PageUtil p) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from user_info limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<UserInfo> list=this.Query(sql);
		return list;
	}
	public List<UserInfo> queryById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from user_info where user_id="+id;
		List<UserInfo> list=this.Query(sql);
		return list;
	}
	public List<UserInfo> queryByUserName(String userName,PageUtil p) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from user_info where user_name like '%"+userName+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<UserInfo> list=this.Query(sql);
		return list;
	}
	public List<UserInfo> queryByDepartmentName(String departmentName,PageUtil p) throws SQLException {//根据部门名字查
		// TODO Auto-generated method stub
		DepartmentDao dd=new DepartmentDao();
		int id=dd.queryIdByName(departmentName);
		String sql="select * from user_info where department_id="+id+" limit "+(p.getFirst()-1)+","+p.getPagesize();;
		System.out.println(sql);
		List<UserInfo> list=this.Query(sql);
		return list;
	}
	public List<UserInfo> queryByRoleName(String roleName,PageUtil p) throws SQLException {//根据角色名字查
		// TODO Auto-generated method stub
		RoleDao rd=new RoleDao();
		int id=rd.queryIdByName(roleName);
		String sql="select * from user_info where role_id="+id+" limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<UserInfo> list=this.Query(sql);
		return list;
	}
	public List<UserInfo> queryByDiploma(String diploma,PageUtil p) throws SQLException {//根据学历查
		// TODO Auto-generated method stub
		String sql="select * from user_info where user_diploma like '%"+diploma+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<UserInfo> list=this.Query(sql);
		return list;
	}
	public String queryNameById(int id) throws SQLException{
		String sql="select * from user_info where user_id="+id;
		List<UserInfo> list=this.Query(sql);
		String name="";
		if(list.size()!=0&&list!=null){
			name=list.get(0).getUser_name();
		}
		return name;
	}
	@Override
	public List<UserInfo> queryByNamePwd(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from user_info where user_num='"+name+"' and user_pw='"+password+"'";
		List<UserInfo> list=this.Query(sql);
		return list;
	}

	@Override
	public int insert(UserInfo user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into user_info values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,?,?,?,?,?,'1')";
		int i=this.update(sql,user.getDepartment_id(),user.getRole_id(),user.getUser_name(),user.getUser_sex()
				,user.getUser_mobile(),user.getUser_age(),user.getUser_address(),user.getUser_num(),user.getUser_pw()
				,user.getUser_tel(),user.getUser_idnum(),user.getUser_email(),user.getUser_addtime(),user.getUser_addman()
				,user.getUser_intest(),user.getUser_diploma(),user.getUser_bankcard()
				,user.getUser_nation(),user.getIs_married());
		return i;
	}

	@Override
	public int delete(UserInfo user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="delete from user_info where user_num='"+user.getUser_num()+"'";
		int i=this.update(sql);
		return i;
	}
	public int deleteUser(int id) throws SQLException{
		String sql="delete from user_info where user_id="+id;
		int i=this.update(sql);
		return i;
	}
	public int queryIdByName(String name) throws SQLException{
		String sql="select * from user_info where user_name='"+name+"'";
		List<UserInfo> list=this.Query(sql);
		if(list.size()!=0){
			return list.get(0).getUser_id();
		}
		return 0;
	}
	@Override
	public int update(UserInfo u) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update user_info set department_id=?,user_name=?,user_sex=?"
				+ ",user_mobile=?,user_age=?,user_address=?,user_tel=?,user_idnum=?"
				+ ",user_email=?,user_addtime=?,user_addman=?,user_changetime=?,user_changeman=?"
				+ ",user_intest=?,user_diploma=?,user_bankcard=?,user_nation=?,is_married=? where user_id=?";
		int i=this.update(sql, u.getDepartment_id(),u.getUser_name(),u.getUser_sex()
				,u.getUser_mobile(),u.getUser_age(),u.getUser_address(),u.getUser_tel(),u.getUser_idnum()
				,u.getUser_email(),u.getUser_addtime(),u.getUser_addman(),u.getUser_changetime(),u.getUser_changeman()
				,u.getUser_intest(),u.getUser_diploma(),u.getUser_bankcard(),u.getUser_nation(),u.getIs_married(),u.getUser_id());
		return i;
	}
	
	@Override
	public ArrayList<UserInfo> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		DepartmentDao dd=new DepartmentDao();
		RoleDao rd=new RoleDao();
		while(rs.next()){
			UserInfo user=new UserInfo();
			user.setUser_id(rs.getInt(1));
			user.setDepartment_id(rs.getInt(2));
			user.setDepartment_name(dd.queryNameById(rs.getInt(2)));
			user.setRole_id(rs.getInt(3));
			user.setRole_name(rd.queryNameById(rs.getInt(3)));
			user.setUser_name(rs.getString(4));
			user.setUser_sex(rs.getString(5));
			user.setUser_mobile(rs.getString(6));
			user.setUser_age(rs.getInt(7));
			user.setUser_address(rs.getString(8));
			user.setUser_num(rs.getString(9));
			user.setUser_pw(rs.getString(10));
			user.setUser_tel(rs.getString(11));
			user.setUser_idnum(rs.getString(12));
			user.setUser_email(rs.getString(13));
			user.setUser_addtime(rs.getTimestamp(14));
			user.setUser_addman(rs.getString(15));
			user.setUser_changetime(rs.getTimestamp(16));
			user.setUser_changeman(rs.getString(17));
			user.setUser_intest(rs.getString(18));
			user.setUser_diploma(rs.getString(19));
			user.setUser_bankcard(rs.getString(20));
			user.setUser_nation(rs.getString(21));
			user.setIs_married(rs.getString(22));
			user.setIs_used(rs.getString(23));
			list.add(user);
		}
		return list;
	}
	
}
