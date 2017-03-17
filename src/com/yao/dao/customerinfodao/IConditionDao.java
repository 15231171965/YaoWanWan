package com.yao.dao.customerinfodao;

import java.sql.SQLException;
import java.util.List;

import com.yao.entity.CustomerCondition;

public interface IConditionDao {
	public int queryIdByName(String name)throws SQLException;
}
