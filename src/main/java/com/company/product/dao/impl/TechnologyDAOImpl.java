package com.company.product.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.company.product.dao.TechnologyDAO;
import com.company.product.domain.Department;
import com.company.product.domain.SkillFactor;
import com.company.product.domain.Technology;

class TechnologyDAOImpl implements TechnologyDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void add(Technology technology) {

		hibernateTemplate.saveOrUpdate(technology);

	}

	public void update(Technology technology) {

		hibernateTemplate.update(technology);

	}

	public void delete(int id) {
		Technology technology = findById(id);
		if (technology != null) {
			hibernateTemplate.delete(technology);
		}

	}

	public Technology findById(int id) {
		Technology technology = hibernateTemplate.get(Technology.class, id);
		return technology;
	}

	public List<Technology> findAll() {
		String query = "from Technology where is_Delete='0'";
		return hibernateTemplate.find(query);
	}

	@Override
	public Technology findByName(String name) {
		// TODO Auto-generated method stub
		return (Technology) hibernateTemplate.getSessionFactory().openSession()
				.createCriteria(Technology.class)
				.add(Restrictions.eq("name", name)).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Technology> findByTechnologyId(int id) {
		String query = "from Technology where DEPARTMENT_ID=" + id;
		return (List<Technology>) hibernateTemplate.getSessionFactory()
				.openSession().createQuery(query).list();
	}


}
