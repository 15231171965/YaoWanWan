package com.yao.dao.customerLinkRecordDao;

import java.sql.SQLException;
import java.util.List;

import com.yao.entity.CustomerLinkrecord;

public interface ICustomerLinkrecordDao {
	public List<CustomerLinkrecord> queryall()throws SQLException;
}
