package com.AayushBaid.SkillTracker.service;

import com.AayushBaid.SkillTracker.dto.SkillDto;
import com.AayushBaid.SkillTracker.model.Skill;
import com.AayushBaid.SkillTracker.model.SkillType;

import java.util.List;

public interface SkillService {

     List<SkillDto> getAllSkills();

    List<Skill> getSkillsByType(int skillTypeId);
    List<SkillType> getAll();

}