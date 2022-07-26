package com.AayushBaid.SkillTracker.service.impl;

import com.AayushBaid.SkillTracker.model.SkillType;
import com.AayushBaid.SkillTracker.repository.SkillTypeRepository;
import com.AayushBaid.SkillTracker.service.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillTypeServiceImpl implements SkillTypeService {


    @Autowired
    private SkillTypeRepository skillTypeRepository;


    @Override
    public List<SkillType> getAllSkillTypes() {
        return skillTypeRepository.findAll();
    }

}