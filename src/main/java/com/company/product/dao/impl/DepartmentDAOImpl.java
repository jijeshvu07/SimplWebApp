package com.company.product.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.company.product.dao.DepartmentDAO;
import com.company.product.domain.Department;
import com.company.product.domain.User;

class DepartmentDAOImpl implements DepartmentDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void add(Department department) {
		hibernateTemplate.saveOrUpdate(department);
	}

	public void update(Department department) {
		hibernateTemplate.update(department);
	}

	public void delete(int id) {
		Department department = findById(id);
		if (department != null) {
			hibernateTemplate.delete(department);
		}

	}

	public Department findById(int id) {
		Department department = hibernateTemplate.get(Department.class, id);
		return department;

	}

	@SuppressWarnings("unchecked")
	public List<Department> findAll() {
		String query = "from Department where is_Delete='0'";
		return hibernateTemplate.find(query);

	}

	
	
	
}
