package com.yao.dao.pagedao;

import java.sql.SQLException;

public interface IPageDao {
	public int getAll(String databasename) throws SQLException;
}
