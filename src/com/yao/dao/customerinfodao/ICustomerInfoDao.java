package com.yao.dao.customerinfodao;

import java.sql.SQLException;
import java.util.List;

import com.yao.entity.CustomerInfo;
import com.yao.util.PageUtil;

public interface ICustomerInfoDao {
	public List<CustomerInfo> queryall()throws SQLException;//查所有
	public List<CustomerInfo> remind(int i) throws SQLException;//查事件提醒
	public List<CustomerInfo> queryByName(String name)throws SQLException;
}
