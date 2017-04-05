package com.jiangsu.web.action;

import com.jiangsu.dao.UserDao;
import com.jiangsu.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	//定义一个用户的数据模型，注意：由于使用了模型驱动，我们必须自己实例化对象
	private User user = new User();
	
	private UserDao userDao = new UserDao();
	

	public String register(){
		//1.根据用户名获取数据库的用户对象
		User dbUser = userDao.selectUserByUsername(user.getUsername());
		//2.判断对象是否存在
		if(dbUser != null){
			//2.1如果存在，则表明用户有了，返回exists的结果视图
			return "exists";
		}
		//3.不存在，保存用户信息
		int res = userDao.addUser(user);
		//4.如果执行结果大于0
		if(res > 0){
			return SUCCESS;
		}
		//5.如果不大于0，返回null
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
