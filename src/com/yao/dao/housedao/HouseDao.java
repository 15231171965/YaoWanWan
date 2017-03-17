package com.yao.dao.housedao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.housetypedao.HouseTypeDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.HouseInfo;
import com.yao.util.PageUtil;

public class HouseDao extends CommonDao{
	public List<HouseInfo> queryAll()throws SQLException{
		String sql="select * from house_info";
		List<HouseInfo> list=this.Query(sql);
		return list;
	}
	public List<HouseInfo> queryAllPage(PageUtil p)throws SQLException{
		String sql="select * from house_info limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<HouseInfo> list=this.Query(sql);
		return list;
	}
	public List<HouseInfo> queryById(int id)throws SQLException{
		String sql="select * from house_info where house_id="+id;
		List<HouseInfo> list=this.Query(sql);
		return list;
	}
	public List<HouseInfo> queryByTypeName(String name,PageUtil p)throws SQLException{
		//HouseTypeDao htd=new HouseTypeDao();
		//int id=htd.queryIdByName(name);
		//String sql="select * from house_info where type_id="+id+" limit "+(p.getFirst()-1)+","+(p.getPagesize());
		String sql="select * from house_info i,house_type t where i.type_id=t.type_id and t.type_name like '%"+name+"%' limit "+(p.getFirst()-1)+","+(p.getPagesize());
		List<HouseInfo> list=this.Query(sql);
		return list;
	}
	public List<HouseInfo> queryByAddress(String address,PageUtil p)throws SQLException{
		String sql="select * from house_info where house_address like '%"+address+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<HouseInfo> list=this.Query(sql);
		return list;
	}
	public int insert(HouseInfo h)throws SQLException{
		String sql="insert into house_info values(null,?,?,?,?,?,'1')";
		int i=this.update(sql,h.getType_id(),h.getUser_id(),h.getHouse_address(),h.getHouse_price(),h.getHouse_ambient());
		return i;
	}
	public int update(HouseInfo h)throws SQLException{
		String sql="update house_info set type_id=?,user_id=?,house_address=?"
				+ ",house_price=?,house_ambient=? where house_id=?";
		int i=this.update(sql, h.getType_id(),h.getUser_id(),h.getHouse_address()
				,h.getHouse_price(),h.getHouse_ambient(),h.getHouse_id());
		return i;
	}
	public int delete(int id)throws SQLException{
		String sql="delete from house_info where house_id="+id;
		int i=this.update(sql);
		return i;
	}
	@Override
	public ArrayList<HouseInfo> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<HouseInfo> list=new ArrayList<HouseInfo>();
		HouseTypeDao htd=new HouseTypeDao();
		UserDao ud=new UserDao();
		while(rs.next()){
			HouseInfo h=new HouseInfo();
			h.setHouse_id(rs.getInt(1));
			h.setType_id(rs.getInt(2));
			h.setType_name(htd.queryNameById(rs.getInt(2)));
			h.setUser_id(rs.getInt(3));
			h.setUser_name(ud.queryNameById(rs.getInt(3)));
			h.setHouse_address(rs.getString(4));
			h.setHouse_price(rs.getInt(5));
			h.setHouse_ambient(rs.getString(6));
			h.setIs_used(rs.getString(7));
			list.add(h);
		}
		return list;
	}
	
}
