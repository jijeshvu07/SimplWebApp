package com.company.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.product.dao.UserRatingDAO;
import com.company.product.domain.UserRating;
import com.company.product.service.UserRatingService;

@Service("userRatingService")
public class UserRatingServiceImpl implements UserRatingService {

	@Autowired
	private UserRatingDAO userRatingDAO;

	@Override
	public void saveUserRating(UserRating userRating) {

		userRatingDAO.add(userRating);
	}

	@Override
	public void updateUserRating(UserRating userRating) {
		userRatingDAO.update(userRating);

	}

	@Override
	public UserRating findUserRatingById(int id) {

		return userRatingDAO.findById(id);
	}

	@Override
	public void deleteUserRating(int id) {

		userRatingDAO.delete(id);
	}

	@Override
	public List<UserRating> findAllUserRating() {

		return userRatingDAO.findAll();
	}

}
