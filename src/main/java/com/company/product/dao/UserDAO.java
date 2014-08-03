package com.company.product.dao;

import java.util.List;

import com.company.product.domain.User;

public interface UserDAO {

	public boolean saveUser(User user);
	public boolean updateUser(User updatedUser);
	public List<User> getAllUsers();
	public void deleteUser(Long id);
	public User getUserById(Long id);
	public boolean checkUserNameAvailbility(String name);
	String getLoggedUserName();
    User findByName(String name);
	User getLoggedUserAccount();
}
