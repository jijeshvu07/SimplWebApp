package com.company.product.service;

import java.util.List;

import com.company.product.domain.UserRating;

public interface UserRatingService {
	void saveUserRating(UserRating userRating);

	void updateUserRating(UserRating userRating);

	UserRating findUserRatingById(int id);

	void deleteUserRating(int id);

	List<UserRating> findAllUserRating();

}
