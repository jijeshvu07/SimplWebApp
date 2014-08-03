package com.company.product.dao;

import java.util.List;



import com.company.product.domain.Department;


public interface DepartmentDAO {
	void add(Department department);

	void update(Department department);

	void delete(int id);

	Department findById(int id);

	List<Department> findAll();
	
	
	
	
}

