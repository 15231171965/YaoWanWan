package com.yao.dao.baobiaodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.customerinfodao.SourceDao;
import com.yao.entity.SourceNum;

public class SourceNumDao extends CommonDao{
//	public static void main(String[] args) throws SQLException {
//		SourceNumDao snd=new SourceNumDao();
//		List<SourceNum> list=snd.queryAll();
//		for (SourceNum sourceNum : list) {
//			System.out.println(sourceNum);
//		}
//	}
	public List<SourceNum> queryAll() throws SQLException{
		String sql="select distinct source_id from customer_info where source_id is not null";
		List<SourceNum> list=this.Query(sql);
		return list;
	}
	@Override
	public ArrayList<SourceNum> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<SourceNum> list=new ArrayList<SourceNum>();
		SourceDao sd=new SourceDao();
		CountDao cd=new CountDao();
		while(rs.next()){
			SourceNum s=new SourceNum();
			s.setSource_id(rs.getInt(1));
			s.setSource_name(sd.queryNameById(rs.getInt(1)));
			s.setNum(cd.queryByFlag("source_id="+rs.getInt(1)));
			list.add(s);
		}
		return list;
	}

}
