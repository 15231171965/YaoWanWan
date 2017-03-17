package com.yao.dao.customerinfodao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yao.dao.commondao.CommonDao;
import com.yao.dao.userdao.UserDao;
import com.yao.entity.CustomerCondition;
import com.yao.entity.CustomerInfo;
import com.yao.entity.CustomerLinkrecord;
import com.yao.util.PageUtil;

public class CustomerInfoDao extends CommonDao implements ICustomerInfoDao{
	public static void main(String[] args) throws SQLException {
		CustomerInfoDao cid=new CustomerInfoDao();
		List<CustomerInfo> list=cid.queryall();//成功
		//List<CustomerInfo> list=cid.queryByStatus("潜在客户");//根据状态查客户成功
		//List<CustomerInfo> list=cid.queryBySource("阿萨德");//根据来源查成功
		//List<CustomerInfo> list=cid.queryByType("客户");//根据客户类型查成功
		//List<CustomerInfo> list=cid.queryByName("李四");//根据客户名字查成功
		//List<CustomerInfo> list=cid.queryByUser("张三");//根据所属员工查成功
		//List<CustomerInfo> list=cid.queryByCompany("思科");//根据所属公司查成功
		//List<CustomerInfo> list=cid.remind(30);
	/*	for (CustomerInfo c : list) {
			System.out.println(c.getCustomer_id());
		}*/
		System.out.println(list.size());
		
	}
	public String queryNameById(int id) throws SQLException{
		String sql="select * from customer_info where customer_id="+id;
		List<CustomerInfo> list=this.Query(sql);
		String name="";
		if(list.size()!=0&&list!=null){
			name=list.get(0).getCustomer_name();
		}
		return name;
	}
	public int queryIdByName(String name) throws SQLException{
		String sql="select * from customer_info where customer_name='"+name+"'";
		List<CustomerInfo> list=this.Query(sql);
		int id=0;
		if(list.size()!=0&&list!=null){
			id=list.get(0).getCustomer_id();
		}
		return id;
	}
	public List<CustomerInfo> queryById(int id) throws SQLException{
		String sql="select * from customer_info where customer_id="+id;
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	@Override
	public List<CustomerInfo> queryall() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from customer_info";
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	public List<CustomerInfo> queryallPage(PageUtil p) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from customer_info limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	@Override
	public List<CustomerInfo> remind(int i) throws SQLException{
		String sql="select * from customer_info where 365-(ABS((UNIX_TIMESTAMP(birth_day)-UNIX_TIMESTAMP(now()))%31536000)/86400)<"+i;
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	@Override
	public List<CustomerInfo> queryByName(String name)throws SQLException{
		String sql="select * from customer_info where customer_name='"+name+"'";
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	public List<CustomerInfo> queryByNamePage(String name,PageUtil p)throws SQLException{
		String sql="select * from customer_info where customer_name like'%"+name+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	public List<CustomerInfo> queryByStatus(String status,PageUtil p)throws SQLException{//根据客户状态
		ConditionDao cd=new ConditionDao();
		int i=cd.queryIdByName(status);
		String sql="select * from customer_info where condition_id='"+i+"' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	public List<CustomerInfo> queryBySource(String Source,PageUtil p)throws SQLException{//根据客户来源
		SourceDao sd=new SourceDao();
		int i=sd.queryIdByName(Source);
		String sql="select * from customer_info where source_id="+i+" limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	public List<CustomerInfo> queryByType(String type,PageUtil p)throws SQLException{//根据客户类型
		TypeDao td=new TypeDao();
		int i=td.queryIdByName(type);
		String sql="select * from customer_info where type_id="+i+" limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	public List<CustomerInfo> queryByUser(String user,PageUtil p)throws SQLException{//根据客户所属员工
		String sql="select c.* from customer_info c ,user_info u where c.user_id=u.user_id and u.user_name like '%"+user+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	public List<CustomerInfo> queryByCompany(String company,PageUtil p)throws SQLException{//根据客户公司
		String sql="select * from customer_info where customer_company like '%"+company+"%' limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	public int update(CustomerInfo c) throws SQLException{//修改
		System.out.println("c="+c.getCustomer_addtime()); 
		String sql="update customer_info set condition_id=?,source_id=?,user_id=?,type_id=?,"
				+ "customer_name=?,customer_sex=?,customer_mobile=?,customer_qq=?,customer_address=?,"
				+ "customer_email=?,customer_remark=?,customer_job=?,customer_blog=?,customer_tel=?,"
				+ "customer_msn=?,customer_addtime=?,customer_addman=?,customer_changetime=?,"
				+ "change_man=?,customer_company=?,is_used=? where customer_id=?";
		int i=this.update(sql, c.getCondition_id(),c.getSource_id(),c.getUser_id(),c.getType_id(),c.getCustomer_name()
					,c.getCustomer_sex(),c.getCustomer_mobile(),c.getCustomer_qq(),c.getCustomer_address()
					,c.getCustomer_email(),c.getCustomer_remark(),c.getCustomer_job(),c.getCustomer_blog(),c.getCustomer_tel()
					,c.getCustomer_msn(),c.getCustomer_addtime(),c.getCustomer_addman(),c.getCustomer_changetime()
					,c.getChange_man(),c.getCustomer_company(),c.getIs_used(),c.getCustomer_id());
		return i;
	}
	public int insert(CustomerInfo c) throws SQLException{//添加  id1  增加日期  改变日期   isused
		//不添加负责员工
		/*this.update(sql,c.getCondition_id(),c.getSource_id(),c.getType_id(),c.getCustomer_name()
				,c.getCustomer_sex(),c.getCustomer_mobile(),c.getCustomer_qq(),c.getCustomer_address()
				,c.getCustomer_email(),c.getCustomer_remark(),c.getCustomer_job(),c.getCustomer_blog(),c.getCustomer_tel()
				,c.getCustomer_msn(),c.getBirth_day(),c.getCustomer_addtime(),c.getCustomer_addman(),c.getCustomer_changetime()
				,c.getChange_man(),c.getCustomer_company());*/
//		insert into customer_info values(null,2,2,null,2,'a','男','123123123','123123','asd','123@qq.com','asd','asd','asd','123123','asd','2017-01-01 12:12:12','2017-01-01 12:12:12','张三','2017-01-01 12:12:12','张三','asd','1');
		/*System.out.println("cond_id:"+c.getCondition_id());
		System.out.println("sid:"+c.getSource_id());
		System.out.println("type_id:"+c.getType_id());
		System.out.println("cust_name:"+c.getCustomer_name());
		System.out.println("sex:"+c.getCustomer_sex());
		System.out.println("mobile:"+c.getCustomer_mobile());
		System.out.println("qq:"+c.getCustomer_qq());
		System.out.println("address:"+c.getCustomer_address());
		System.out.println("email:"+c.getCustomer_email());
		System.out.println("remark:"+c.getCustomer_remark());
		System.out.println("job:"+c.getCustomer_job());
		System.out.println("blog:"+c.getCustomer_blog());
		System.out.println("tel:"+c.getCustomer_tel());
		System.out.println("msn:"+c.getCustomer_msn());
		System.out.println("birthday:"+c.getBirth_day());
		System.out.println("addtime:"+c.getCustomer_addtime());
		System.out.println("addman:"+c.getCustomer_addman());
		System.out.println("changtime:"+c.getCustomer_changetime());
		System.out.println("changeman:"+c.getChange_man());
		System.out.println("company:"+c.getCustomer_company());*/
		String sql="insert into customer_info values(null,?,?,null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'1')";
		int i=this.update(sql,c.getCondition_id(),c.getSource_id(),c.getType_id(),c.getCustomer_name()
				,c.getCustomer_sex(),c.getCustomer_mobile(),c.getCustomer_qq(),c.getCustomer_address()
				,c.getCustomer_email(),c.getCustomer_remark(),c.getCustomer_job(),c.getCustomer_blog(),c.getCustomer_tel()
				,c.getCustomer_msn(),c.getBirth_day(),c.getCustomer_addtime(),c.getCustomer_addman(),c.getCustomer_changetime()
				,c.getChange_man(),c.getCustomer_company());
		return i;
	}
	public int delete(int i) throws SQLException{//删除
		String sql="delete from customer_info where customer_id="+i;
		int l=this.update(sql);
		return l;
	}
	
	public List<CustomerInfo> queryAllUnallocated(PageUtil p) throws SQLException{//查所有未分配的
		String sql="select * from customer_info where user_id is null limit "+(p.getFirst()-1)+","+p.getPagesize();
		List<CustomerInfo> list=this.Query(sql);
		return list;
	}
	public int updateUnallocated(int customerId,int userId) throws SQLException{//修改未分配对象
		String sql="update customer_info set user_id="+userId+" where customer_id="+customerId;
		int i=this.update(sql);
		return i;
	}
	public ArrayList<CustomerInfo> getList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<CustomerInfo> list=new ArrayList<CustomerInfo>();
		ConditionDao cd=new ConditionDao();
		SourceDao sd=new SourceDao();
		UserDao ud=new UserDao();
		TypeDao td=new TypeDao();
		while(rs.next()){
			CustomerInfo c=new CustomerInfo();
			c.setCustomer_id(rs.getInt(1));
			c.setCondition_id(rs.getInt(2));
			c.setCondition_name(cd.queryNameById(rs.getInt(2)));
			c.setSource_id(rs.getInt(3));
			c.setSource_name(sd.queryNameById(rs.getInt(3)));
			c.setUser_id(rs.getInt(4));
			c.setUser_name(ud.queryNameById(rs.getInt(4)));
			c.setType_id(rs.getInt(5));
			c.setType_name(td.queryNameById(rs.getInt(5)));
			c.setCustomer_name(rs.getString(6));
			c.setCustomer_sex(rs.getString(7));
			c.setCustomer_mobile(rs.getString(8));
			c.setCustomer_qq(rs.getString(9));
			c.setCustomer_address(rs.getString(10));
			c.setCustomer_email(rs.getString(11));
			c.setCustomer_remark(rs.getString(12));
			c.setCustomer_job(rs.getString(13));
			c.setCustomer_blog(rs.getString(14));
			c.setCustomer_tel(rs.getString(15));
			c.setCustomer_msn(rs.getString(16));
			c.setBirth_day(rs.getTimestamp(17));
			c.setCustomer_addtime(rs.getTimestamp(18));
			c.setCustomer_addman(rs.getString(19));
			c.setCustomer_changetime(rs.getTimestamp(20));
			c.setChange_man(rs.getString(21));
			c.setCustomer_company(rs.getString(22));
			c.setIs_used(rs.getString(23));
			list.add(c);
		}
		return list;
	}

}
