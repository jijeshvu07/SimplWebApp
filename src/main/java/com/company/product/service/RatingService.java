package com.company.product.service;

import java.util.List;

import com.company.product.domain.Rating;

public interface RatingService {
	void saveRating(Rating rating);

	void updateRating(Rating rating);

	List<Rating> findAllRating();

	Rating findRatingById(int id);

	void deleteRating(int id);
}
