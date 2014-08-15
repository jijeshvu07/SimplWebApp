package com.company.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.product.dao.DepartmentDAO;
import com.company.product.domain.Department;
import com.company.product.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Override
	public void saveDept(Department department) {
		departmentDAO.add(department);

	}

	@Override
	public void updateDept(Department department) {
		departmentDAO.update(department);
	}

	@Override
	public Department findDeptById(int id) {

		return departmentDAO.findById(id);
	}

	@Override
	public void deleteDept(int id) {
		departmentDAO.delete(id);
	}

	@Override
	public List<Department> findAllDept() {

		return departmentDAO.findAll();
	}

	@Override
	public Department findDepartmentByName(String name) {
		
		return departmentDAO.findByName(name);
	}

	@Override
	public boolean checkExists(String name) {
		
		return departmentDAO.checkExists(name);
	}

	

	

}
