package com.yao.dao.noticeinfodao;

import java.sql.SQLException;
import java.util.List;

import com.yao.entity.NoticeInfo;

public interface INoticeInfoDao {
	public List<NoticeInfo> queryall() throws SQLException;
}
