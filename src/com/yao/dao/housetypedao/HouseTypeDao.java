package com.yao.dao.housetypedao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.entity.HouseType;
import com.yao.util.PageUtil;

public class HouseTypeDao extends CommonDao{
	public List<HouseType> queryAll() throws SQLException{
		String sql="select * from house_type";
		List<HouseType> list=this.Query(sql);
		return list;
	}
	public List<HouseType> queryAllPage(PageUtil p) throws SQLException{
		String sql="select * from house_type limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<HouseType> list=this.Query(sql);
		return list;
	}
	public List<HouseType> queryByName(String name ,PageUtil p) throws SQLException{
		String sql="select * from house_type where type_name like '%"+name+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<HouseType> list=this.Query(sql);
		return list;
	}
	public String queryNameById(int id) throws SQLException{
		String sql="select * from house_type where type_id="+id;
		List<HouseType> list=this.Query(sql);
		String name="";
		if(list!=null&&list.size()!=0){
			name=list.get(0).getType_name();
		}
		return name;
	}
	public int queryIdByName(String name)throws SQLException{
		String sql="select * from house_type where type_name='"+name+"'";
		List<HouseType> list=this.Query(sql);
		int id=0;
		if(list!=null&&list.size()!=0){
			id=list.get(0).getType_id();
		}
		return id;
	}
	public int insert (String name)throws SQLException{
		String sql="insert into house_type values(null,'"+name+"','1')";
		int i=this.update(sql);
		return i;
	}
	public int delete (int id)throws SQLException{
		String sql="delete from house_type where type_id="+id;
		int i=this.update(sql);
		return i;
	}
	@Override
	public ArrayList<HouseType> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<HouseType> list=new ArrayList<HouseType>();
		while(rs.next()){
			HouseType h=new HouseType();
			h.setType_id(rs.getInt(1));
			h.setType_name(rs.getString(2));
			h.setIs_used(rs.getString(3));
			list.add(h);
		}
		return list;
	}
	
}
