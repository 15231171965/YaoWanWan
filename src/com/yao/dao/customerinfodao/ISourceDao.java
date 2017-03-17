package com.yao.dao.customerinfodao;

import java.sql.SQLException;

public interface ISourceDao {
	public int queryIdByName(String name) throws SQLException;
}
