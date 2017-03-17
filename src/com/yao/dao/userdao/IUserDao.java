package com.yao.dao.userdao;

import java.sql.SQLException;
import java.util.List;

import com.yao.entity.UserInfo;

public interface IUserDao {
	public List<UserInfo> queryAll() throws SQLException;
	public List<UserInfo> queryByNamePwd(String name,String password)throws SQLException;
	public int insert(UserInfo user)throws SQLException;
	public int delete(UserInfo user)throws SQLException;
	public int update(UserInfo user)throws SQLException;
}
