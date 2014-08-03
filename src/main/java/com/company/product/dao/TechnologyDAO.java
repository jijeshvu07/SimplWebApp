package com.company.product.dao;

import java.util.List;


import com.company.product.domain.Technology;

public interface TechnologyDAO {
	void add(Technology technology);

	void update(Technology technology);

	void delete(int id);

	Technology findById(int id);

	List<Technology> findAll();

	Technology findByName(String name);

	List<Technology> findByTechnologyId(int id);
}
