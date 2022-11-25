package com.boot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.demo.model.User;

public interface UserDao extends JpaRepository<User,Integer>{

	@Query("select u from User u where u.userName =:name")
	public User getUserByUserName(@Param("name") String name);
}
