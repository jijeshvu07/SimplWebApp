package com.company.product.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.company.product.dao.UserRatingDAO;
import com.company.product.domain.UserRating;

class UserRatingDAOImpl implements UserRatingDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void add(UserRating userRating) {

		hibernateTemplate.saveOrUpdate(userRating);
	}

	public void update(UserRating userRating) {

		hibernateTemplate.update(userRating);
	}

	public void delete(int id) {
		UserRating userRating = findById(id);
		if (userRating != null) {
			hibernateTemplate.delete(userRating);
		}

	}

	public UserRating findById(int id) {

		return hibernateTemplate.get(UserRating.class, id);
	}

	public List<UserRating> findAll() {
		String query="from UserRating where is_Delete='false'";
		return hibernateTemplate.find(query);
	}

}
