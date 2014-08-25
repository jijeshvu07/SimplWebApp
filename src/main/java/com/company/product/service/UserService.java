package com.company.product.service;

import java.util.List;

import com.company.product.domain.User;

public interface UserService {

	public boolean saveUser(User user);
	public boolean updateUser(User updatedUser);
	public List<User> getAllUsers();
	public void deleteUser(Long id);
	public User getUserById(Long id);
	public boolean userAlreadyTakenValidation(String userName);
	public String getLoggedUserName();
	User getLoggedUserAccount();
	User userByUserName(String name);
}
