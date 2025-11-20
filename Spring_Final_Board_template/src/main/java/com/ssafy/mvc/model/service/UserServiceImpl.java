package com.ssafy.mvc.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
	
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		// TODO Auto-generated method stub
//		System.out.println("user = "  + user + " and already come into UserService");
//		System.out.println(user.getId());
//		System.out.println(user.getCurriculumCode());
		userDao.insertUser(user);
	}

	@Override
	public User login(String id, String password) {
		// TODO Auto-generated method stub
		Map<String , String> info = new HashMap<>();
		info.put("id", id);
		info.put("password", password);
		
		
		User tmp = userDao.selectOne(info);
		System.out.println(tmp);
		return tmp;
	}
	
}
