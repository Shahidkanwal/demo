package com.boot.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.boot.demo.dao.UserDao;
import com.boot.demo.model.User;

public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		//fetching user from database
		
		User user = this.userDao.getUserByUserName(name);
		if (user == null) {
			throw new UsernameNotFoundException("Could not found user!!");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}

}
