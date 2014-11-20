package cn.com.ql.bean;

import java.util.Date;

public class UserInfo {
	private int id;
	private String username;
	private String password;
	private int age;
	private Date makedate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getMakedate() {
		return makedate;
	}
	public void setMakedate(Date makedate) {
		this.makedate = makedate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", password="
				+ password + ", age=" + age + ", makedate=" + makedate + "]";
	}
	
	
}
