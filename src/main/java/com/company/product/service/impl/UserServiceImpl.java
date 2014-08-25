package com.company.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.product.dao.UserDAO;
import com.company.product.domain.User;
import com.company.product.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean saveUser(User user) {
		return userDAO.saveUser(user);
	}

	@Override
	public boolean updateUser(User updatedUser) {
		return userDAO.updateUser(updatedUser);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public void deleteUser(Long id) {
		userDAO.deleteUser(id);
	}

	@Override
	public User getUserById(Long id) {
		return userDAO.getUserById(id);
	}

	@Override
	public boolean userAlreadyTakenValidation(String userName) {

		return userDAO.checkUserNameAvailbility(userName);
	}

	@Override
	public String getLoggedUserName() {
		
		return userDAO.getLoggedUserName();
	}

	@Override
	public User getLoggedUserAccount() {
		
		return userDAO.getLoggedUserAccount();
	}

	@Override
	public User userByUserName(String name) {
		
		return userDAO.findByName(name);
	}

	

}
