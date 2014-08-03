package com.company.product.dao;

import java.util.List;



import com.company.product.domain.UserRating;


public interface UserRatingDAO {
	void add(UserRating userRating);

	void update(UserRating userRating);

	void delete(int id);

	UserRating findById(int id);

	List<UserRating> findAll();
}


