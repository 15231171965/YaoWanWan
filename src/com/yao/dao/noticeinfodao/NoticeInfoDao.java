package com.yao.dao.noticeinfodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.CustomerInfo;
import com.yao.entity.NoticeInfo;
import com.yao.util.PageUtil;

public class NoticeInfoDao extends CommonDao implements INoticeInfoDao{
	/*public static void main(String[] args) throws SQLException {
		NoticeInfoDao nid=new NoticeInfoDao();
		List<NoticeInfo> list=nid.queryall();//成功
		for (NoticeInfo n : list) {
			System.out.println(n.getNotice_id());
		}
	}*/
	
	@Override
	public List<NoticeInfo> queryall() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from notice_info where UNIX_TIMESTAMP(notice_endtime)>UNIX_TIMESTAMP(now())";
		List<NoticeInfo> list=this.Query(sql);
		return list;
	}
	public List<NoticeInfo> zhenQueryAll()throws SQLException{
		String sql="select * from notice_info";
		List<NoticeInfo> list=this.Query(sql);
		return list;
	}
	public List<NoticeInfo> zhenQueryAllPage(PageUtil p)throws SQLException{
		String sql="select * from notice_info limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<NoticeInfo> list=this.Query(sql);
		return list;
	}
	public List<NoticeInfo> queryByTheme(String theme,PageUtil p)throws SQLException{
		String sql="select * from notice_info where notice_item like '%"+theme+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<NoticeInfo> list=this.Query(sql);
		return list;
	}
	public List<NoticeInfo> queryByContent(String content,PageUtil p)throws SQLException{
		String sql="select * from notice_info where notice_content like '%"+content+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<NoticeInfo> list=this.Query(sql);
		return list;
	}
	public int insert(NoticeInfo n)throws SQLException{
		String sql="insert into notice_info values(null,?,?,?,?,?,'1')";
		int i=this.update(sql, n.getUser_id(),n.getNotice_item(),n.getNotice_content()
				,n.getNotice_time(),n.getNotice_endtime());
		return i;
	}
	public int delete(int id)throws SQLException{
		String sql="delete from notice_info where notice_id="+id;
		int i=this.update(sql);
		return i;
	}
	@Override
	public  ArrayList<NoticeInfo> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<NoticeInfo> list =new ArrayList<NoticeInfo>();
		UserDao ud=new UserDao();
		while(rs.next()){
			NoticeInfo n=new NoticeInfo();
			n.setNotice_id(rs.getInt(1));
			n.setUser_id(rs.getInt(2));
			n.setUser_name(ud.queryNameById(rs.getInt(2)));
			n.setNotice_item(rs.getString(3));
			n.setNotice_content(rs.getString(4));
			n.setNotice_time(rs.getTimestamp(5));
			n.setNotice_endtime(rs.getTimestamp(6));
			n.setIs_used(rs.getString(7));
			list.add(n);
		}
		return list;
	}

}
