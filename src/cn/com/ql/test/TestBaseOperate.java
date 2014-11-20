package cn.com.ql.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.com.ql.bean.UserInfo;

public class TestBaseOperate {
	private SqlSession session ;
	private boolean flag = true;
	@Before
	public void before(){
		try{
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
			session = factory.openSession();
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}
	}
	
	@Test
	public void insert(){
		if(flag){
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername("张三");
			userInfo.setPassword("123");
			userInfo.setAge(30);
			userInfo.setMakedate(new Date());
			session.insert("mybatis.operate.insert", userInfo);
		}else{
			System.out.println("创建session对象失败");
		}
		
	}
	
	@Test
	public void selectById(){
		UserInfo userinfo = session.selectOne("mybatis.operate.getSigleUserInfo", 1);
		System.out.println(userinfo);
	}
	
	@Test
	public void selectAll(){
		List<UserInfo> all = session.selectList("mybatis.operate.getAllUserInfo");
		for(UserInfo userinfo:all){
			System.out.println(userinfo);
		}
	}
	
	@Test
	public void update(){
		UserInfo userinfo = session.selectOne("mybatis.operate.getSigleUserInfo", 1);
		userinfo.setAge(31);
		session.update("mybatis.operate.updateUserInfoById", userinfo);
	}
	
	@Test
	public void delete(){
		session.delete("mybatis.operate.deleteUserInfoById",1);
	}
	@After
	public void after(){
		if(flag){
			session.commit();
			session.close();
		}
	}

}
