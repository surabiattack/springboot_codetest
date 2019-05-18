package com.codetest.dwi.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.dwi.common.Response;
import com.codetest.dwi.dao.UserDao;
import com.codetest.dwi.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping("/users")
	public List<User> getUsers() {
		return (List<User>) getUserDao().findAll();
	}

	@PostMapping("/user")
	public Response createUser(@Valid @RequestBody User user) {
		Response res = new Response();
		try {
			List<String> errMessage = validation(user);
			if (errMessage.isEmpty()) {
				user.setCreatedBy("user");
				user.setCreatedDate(new Timestamp(new Date().getTime()));
				userDao.save(user);
				res.setStatus(Response.SUCCESS);
				res.setMessage("Register Success");
			} else {
				res.setStatus(Response.FAILED);
				res.setArrMessage(errMessage);
			}
		} catch (Exception e) {
			res.setStatus(Response.FAILED);
			res.setArrMessage(new ArrayList<String>() {
				{
					add("Register failed = " + e.getMessage());
				}
			});
			e.printStackTrace();
		}

		return res;
	}

	private List<String> validation(User user) {
		List<String> errMessage = new ArrayList<String>();

		if (!StringUtils.hasText(user.getMobileNumber())) {
			errMessage.add("Mobile Number required");
		} else {
			User mobile = userDao.findByMobileNumber(user.getMobileNumber());
			if (mobile != null) {
				errMessage.add("Mobile Number already registered");
			}
		}

		if (!StringUtils.hasText(user.getEmail())) {
			errMessage.add("Email required");
		} else {
			User email = userDao.findByEmail(user.getEmail());
			if (email != null) {
				errMessage.add("Email already registered");
			}
		}

		if (!StringUtils.hasText(user.getFirstName())) {
			errMessage.add("First Name required");
		}

		if (!StringUtils.hasText(user.getLastName())) {
			errMessage.add("Last Name required");
		}

//    	try {
//    		
//    	}catch (Exception e) {
//		}

		return errMessage;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
