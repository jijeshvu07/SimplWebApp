package com.company.product.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.company.product.dao.RatingDAO;
import com.company.product.domain.Rating;


class RatingDAOImpl implements RatingDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void add(Rating rating) {
		hibernateTemplate.saveOrUpdate(rating);

	}

	public void update(Rating rating) {
		hibernateTemplate.update(rating);
	}

	public void delete(int id) {
		Rating rating = findById(id);
		if (rating != null) {
			hibernateTemplate.delete(rating);
		}
	}

	public Rating findById(int id) {
		Rating rating = hibernateTemplate.get(Rating.class, id);
		return rating;
	}

	
	public List<Rating> findAll() {
		String query="from Rating where is_Delete='0'";
		return hibernateTemplate.find(query);
		
	}

	@Override
	public boolean checkExists(String name) {
		boolean result = hibernateTemplate.getSessionFactory().openSession()
				.createQuery("from Rating where name=:name")
				.setParameter("name", name).uniqueResult() != null;
		return result;
	}

}
