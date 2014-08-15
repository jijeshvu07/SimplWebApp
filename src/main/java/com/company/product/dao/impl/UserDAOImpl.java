package com.company.product.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.company.product.dao.UserDAO;
import com.company.product.domain.User;

public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public boolean saveUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean updateUser(User updatedUser) {
		hibernateTemplate.update(updatedUser);
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		String query = "from User";
		return hibernateTemplate.find(query);
	}

	@Override
	public void deleteUser(Long id) {
		User user = getUserById(id);
		if (user != null) {
			hibernateTemplate.delete(user);
		}
	}

	@Override
	public User getUserById(Long id) {
		User user = hibernateTemplate.get(User.class, id);
		return user;
	}

	@Override
	public boolean checkUserNameAvailbility(String name) {
	
		boolean result = hibernateTemplate.getSessionFactory().openSession()
				.createQuery("from User where name=:name")
				.setParameter("name", name).uniqueResult() != null;
		return result;
	}

	@Override
	public String getLoggedUserName() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		return authentication.getName();
	}

	@Override
	public User getLoggedUserAccount() {

		return findByName(getLoggedUserName());
	}

	@Override
	public User findByName(String name) {
		return (User) hibernateTemplate.getSessionFactory().openSession()
				.createCriteria(User.class).add(Restrictions.eq("name", name))
				.uniqueResult();
	}

}
