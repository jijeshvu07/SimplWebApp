package com.company.product.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.company.product.dao.SkillFactorDAO;
import com.company.product.domain.SkillFactor;

class SkillFactorDAOImpl implements SkillFactorDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void update(SkillFactor skillFactor) {
		hibernateTemplate.update(skillFactor);
	}

	public void delete(int id) {
		SkillFactor skillFactor = findById(id);
		if (skillFactor != null) {
			hibernateTemplate.delete(skillFactor);
		}

	}

	public SkillFactor findById(int id) {
		SkillFactor factor = hibernateTemplate.get(SkillFactor.class, id);
		return factor;
	}

	public List<SkillFactor> findAll() {
		String query = "from SkillFactor where is_Delete='0'";
		return hibernateTemplate.find(query);
	}

	@Override
	public void add(SkillFactor skillFactor) {
		hibernateTemplate.saveOrUpdate(skillFactor);

	}

	@Override
	public SkillFactor findByName(String name) {
		/*
		 * Session session=sessionFactory.getCurrentSession(); Users
		 * users=(Users)
		 * session.createCriteria(Users.class).add(Restrictions.eq("userName",
		 * name)).uniqueResult();
		 */

		return (SkillFactor) hibernateTemplate.getSessionFactory()
				.openSession().createCriteria(SkillFactor.class)
				.add(Restrictions.eq("factorName", name)).uniqueResult();
	}

}
