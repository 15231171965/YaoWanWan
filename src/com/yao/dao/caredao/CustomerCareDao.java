package com.yao.dao.caredao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.customerinfodao.CustomerInfoDao;
import com.yao.entity.Care;
import com.yao.util.PageUtil;

public class CustomerCareDao extends CommonDao implements ICareDao{
		/*public static void main(String[] args) throws SQLException {
			CustomerCareDao ccd=new CustomerCareDao();
			List<Care> list=ccd.queryall();//通过
			for (Care care : list) {
				System.out.println(care.getCare_id());
			}
		}*/
	@Override
	public List<Care> queryall(PageUtil pageutil) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from customer_care limit "+(pageutil.getFirst()-1)+","+pageutil.getPagesize();
		List<Care> list=this.Query(sql);		
		return list;
	}
	
	public Care queryById(int id) throws SQLException{
		String sql="select * from customer_care where care_id="+id;
		List<Care> list=this.Query(sql);
		if(list!=null&&list.size()!=0)
			return list.get(0);
		else
			return null;
	}
	
	public List<Care> remind(int i) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from customer_care where UNIX_TIMESTAMP(care_nexttime)-UNIX_TIMESTAMP(now())<"+i+"*86400"
				+ "&&UNIX_TIMESTAMP(care_nexttime)-UNIX_TIMESTAMP(now())>0";
		List<Care> list=this.Query(sql);
		return list;
	}
	public List<Care> queryByCustomerName(String name,PageUtil pageutil) throws SQLException{//多表，根据客户名字查关怀
		String sql="select a.* from customer_care a,customer_info b where a.customer_id=b.customer_id and b.customer_name like '%"+name+"%' limit "+(pageutil.getFirst()-1)+","+pageutil.getPagesize();
		List<Care> list=this.Query(sql);
		return list;
	}
	public List<Care> queryByTheme(String theme,PageUtil pageutil) throws SQLException{//根据关怀主题查关怀
		String sql="select * from customer_care where care_theme like '%"+theme+"%' limit "+(pageutil.getFirst()-1)+","+pageutil.getPagesize();
		List<Care> list=this.Query(sql);
		return list;
	}
	public List<Care> queryByCareWay(String careway,PageUtil pageutil)throws SQLException{// 根据关怀方式查关怀
		String sql="select * from customer_care where care_way like '%"+careway+"%' limit "+(pageutil.getFirst()-1)+","+pageutil.getPagesize();
		List<Care> list=this.Query(sql);
		return list;
	}
	public int insertCare(Care care) throws SQLException{//添加客户关怀
		String sql="insert into customer_care values(null,?,?,?,now(),?,?,?,'1')";
		int i=this.update(sql, care.getCustomer_id(),care.getCare_theme(),care.getCare_way(),
				care.getCare_remark(),care.getCare_nexttime(),care.getCare_people());
		return i;
	}
	public int updateCare(Care care) throws SQLException{//修改客户关怀
		String sql="update customer_care set customer_id=?,care_theme=?,care_way=?"
				+ ",care_nexttime=?,care_people=?,care_remark=? where care_id=?";
		int i=this.update(sql, care.getCustomer_id(),care.getCare_theme(),care.getCare_way()
				,care.getCare_nexttime(),care.getCare_people(),care.getCare_remark(),care.getCare_id());
		return i;
	}
	
	public int deleteCare(int id) throws SQLException{
		String sql="delete from customer_care where care_id="+id;
		int i=this.update(sql);
		return i;
	}	
	@Override
	public ArrayList<Care> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Care> list=new ArrayList<Care>();
		CustomerInfoDao cid=new CustomerInfoDao();
		while(rs.next()){
			Care care=new Care();
			care.setCare_id(rs.getInt(1));
			care.setCustomer_name(cid.queryNameById(rs.getInt(2)));
			care.setCustomer_id(rs.getInt(2));
			care.setCare_theme(rs.getString(3));
			care.setCare_way(rs.getString(4));
			care.setCare_time(rs.getTimestamp(5));
			care.setCare_remark(rs.getString(6));
			care.setCare_nexttime(rs.getTimestamp(7));
			care.setCare_people(rs.getString(8));
			care.setIs_used(rs.getString(9));
			list.add(care);
		}
		return list;
	}
}
