package com.company.product.service;

import java.util.List;

import com.company.product.domain.SkillFactor;

public interface SkillFactorService {
void saveSkillFactor(SkillFactor skillFactor);
void updateSkillFactor(SkillFactor skillFactor);
List<SkillFactor>findAllSkilFactor();
SkillFactor findSkillFactorById(int id);
void deleteSkillFactor(int id);
SkillFactor findSkillFactorByName(String name);
}
