package com.AayushBaid.SkillTracker.Controller;

import com.AayushBaid.SkillTracker.dto.SkillDto;
import com.AayushBaid.SkillTracker.model.CandidateSkill;
import com.AayushBaid.SkillTracker.model.Skill;
import com.AayushBaid.SkillTracker.model.SkillType;
import com.AayushBaid.SkillTracker.repository.CandidateRepository;
import com.AayushBaid.SkillTracker.service.SkillService;
import com.AayushBaid.SkillTracker.service.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
@RequestMapping(path = "/skills")
public class SkillController {

    @Autowired
    SkillService skillService;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    SkillTypeService skillTypeService;


    @GetMapping("")
    public ResponseEntity<List<SkillDto>> getAllSkills() {

        List<SkillDto> skills = skillService.getAllSkills();
        if (skills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<SkillDto>>(skills, HttpStatus.OK);
    }


 
    @GetMapping("/{skillTypeId}")
    public ResponseEntity<List<Skill>> getSkills(@PathVariable int skillTypeId) {

        List<Skill> skills = skillService.getSkillsByType(skillTypeId);
        if (skills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Skill>>(skills, HttpStatus.OK);
    }

    
    @GetMapping(path = "/getSkillTypes")
    public List<SkillType> getSkillTypes() {
        List<SkillType> skillType = skillTypeService.getAllSkillTypes();
        if (null != skillType) {
            return skillType;
        } else {
            throw new RestClientException("Skill Type Doesn't Found");
        }
    }
}