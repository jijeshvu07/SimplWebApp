package com.company.product.service;

import java.util.List;

import com.company.product.domain.Technology;

public interface TechnologyService {
	void saveTechnology(Technology technology);

	void updateTechnology(Technology technology);

	Technology findTechologyById(int id);

	void deleteTechnology(int id);

	List<Technology> findAllTechnology();

	Technology findTechnologyByName(String name);

	List<Technology> findTechnologyByDepartmentId(int id);
	
	boolean checkExists(String name);
}
