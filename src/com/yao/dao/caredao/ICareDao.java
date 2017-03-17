package com.yao.dao.caredao;

import java.sql.SQLException;
import java.util.List;

import com.yao.entity.Care;
import com.yao.util.PageUtil;

public interface ICareDao {
	public List<Care> queryall(PageUtil pageutil)throws SQLException;
}
