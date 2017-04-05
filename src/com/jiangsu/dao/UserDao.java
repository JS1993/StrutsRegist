package com.jiangsu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jiangsu.domain.User;
import com.jiangsu.utils.DBCPUtil;

public class UserDao {
	private QueryRunner qurRunner = new QueryRunner(DBCPUtil.getDataSource());
	
	public  User selectUserByUsername(String username) {
		try{
			return qurRunner.query("select * from users where username = ? ",new BeanHandler<User>(User.class),username);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public  int addUser(User user) {
		try{
			return qurRunner.update("insert into users(username,password,birthday,hobby,married)values(?,?,?,?,?)",user.getUsername(),user.getPassword(),user.getBirthday(),user.getHobby(),user.isMarried());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
