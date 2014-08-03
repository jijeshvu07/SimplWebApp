package com.company.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.product.dao.RatingDAO;
import com.company.product.domain.Rating;
import com.company.product.service.RatingService;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDAO ratingDAO;

	@Override
	public void saveRating(Rating rating) {

		ratingDAO.add(rating);
	}

	@Override
	public void updateRating(Rating rating) {

		ratingDAO.update(rating);
	}

	@Override
	public List<Rating> findAllRating() {

		return ratingDAO.findAll();
	}

	@Override
	public Rating findRatingById(int id) {

		return ratingDAO.findById(id);
	}

	@Override
	public void deleteRating(int id) {
		ratingDAO.delete(id);

	}

}
