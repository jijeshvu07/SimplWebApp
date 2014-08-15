package com.company.product.dao;

import java.util.List;



import com.company.product.domain.Rating;


public interface RatingDAO {
	void add(Rating rating);

	void update(Rating rating);

	void delete(int id);

	Rating findById(int id);

	List<Rating> findAll();
	
	boolean checkExists(String name);
}


