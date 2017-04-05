package com.jiangsu.web.action;

import com.jiangsu.dao.UserDao;
import com.jiangsu.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	//����һ���û�������ģ�ͣ�ע�⣺����ʹ����ģ�����������Ǳ����Լ�ʵ��������
	private User user = new User();
	
	private UserDao userDao = new UserDao();
	

	public String register(){
		//1.�����û�����ȡ���ݿ���û�����
		User dbUser = userDao.selectUserByUsername(user.getUsername());
		//2.�ж϶����Ƿ����
		if(dbUser != null){
			//2.1������ڣ�������û����ˣ�����exists�Ľ����ͼ
			return "exists";
		}
		//3.�����ڣ������û���Ϣ
		int res = userDao.addUser(user);
		//4.���ִ�н������0
		if(res > 0){
			return SUCCESS;
		}
		//5.���������0������null
		return null;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	
	
	
}
