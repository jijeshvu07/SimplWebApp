package com.company.product.service;

import java.util.List;

import com.company.product.domain.Department;

public interface DepartmentService {

	void saveDept(Department department);

	void updateDept(Department department);

	Department findDeptById(int id);

	void deleteDept(int id);

	List<Department> findAllDept();

	Department findDepartmentByName(String name);

	boolean checkExists(String name);
}
