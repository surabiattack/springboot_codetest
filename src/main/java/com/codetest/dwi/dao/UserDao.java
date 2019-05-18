package com.codetest.dwi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetest.dwi.model.User;

public interface UserDao extends JpaRepository<User, Long> {
	public User findByEmail(String email);
	public User findByMobileNumber(String mobileNumber);
}
