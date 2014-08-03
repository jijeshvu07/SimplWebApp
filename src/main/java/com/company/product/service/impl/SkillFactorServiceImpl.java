package com.company.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.product.dao.SkillFactorDAO;
import com.company.product.domain.SkillFactor;
import com.company.product.service.SkillFactorService;

@Service("skillFactorService")
public class SkillFactorServiceImpl implements SkillFactorService {

	@Autowired
	private SkillFactorDAO skillFactorDAO;

	@Override
	public void saveSkillFactor(SkillFactor skillFactor) {

		skillFactorDAO.add(skillFactor);
	}

	@Override
	public void updateSkillFactor(SkillFactor skillFactor) {
		skillFactorDAO.update(skillFactor);
	}

	@Override
	public List<SkillFactor> findAllSkilFactor() {

		return skillFactorDAO.findAll();
	}

	@Override
	public SkillFactor findSkillFactorById(int id) {

		return skillFactorDAO.findById(id);
	}

	@Override
	public void deleteSkillFactor(int id) {

		skillFactorDAO.delete(id);
	}

	@Override
	public SkillFactor findSkillFactorByName(String name) {
	
		return skillFactorDAO.findByName(name);
	}

}
