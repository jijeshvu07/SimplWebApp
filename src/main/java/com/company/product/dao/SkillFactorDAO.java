package com.company.product.dao;

import java.util.List;


import com.company.product.domain.SkillFactor;


public interface SkillFactorDAO {
	void add(SkillFactor skillFactor);

	void update(SkillFactor skillFactor);

	void delete(int id);

	SkillFactor findById(int id);

	List<SkillFactor> findAll();
	SkillFactor findByName(String name);
}



