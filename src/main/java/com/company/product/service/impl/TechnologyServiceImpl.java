package com.company.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.product.dao.TechnologyDAO;
import com.company.product.domain.Technology;
import com.company.product.service.TechnologyService;

@Service("technologyService")
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	private TechnologyDAO technologyDAO;

	@Override
	public void saveTechnology(Technology technology) {
		technologyDAO.add(technology);
	}

	@Override
	public void updateTechnology(Technology technology) {
		technologyDAO.update(technology);
	}

	@Override
	public Technology findTechologyById(int id) {

		return technologyDAO.findById(id);
	}

	@Override
	public void deleteTechnology(int id) {
		technologyDAO.delete(id);
	}

	@Override
	public List<Technology> findAllTechnology() {

		return technologyDAO.findAll();
	}

	@Override
	public Technology findTechnologyByName(String name) {
		
		return technologyDAO.findByName(name);
	}

	@Override
	public List<Technology> findTechnologyByDepartmentId(int id) {
		
		return technologyDAO.findByTechnologyId(id);
	}

	@Override
	public boolean checkExists(String name) {
		
		return technologyDAO.checkExists(name);
	}

}
