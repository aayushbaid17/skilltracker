package com.AayushBaid.SkillTracker.Controller;

import com.AayushBaid.SkillTracker.dto.CandidateSkillDto;
import com.AayushBaid.SkillTracker.model.*;
import com.AayushBaid.SkillTracker.repository.*;
import com.AayushBaid.SkillTracker.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {


    @Autowired
    CandidateService candidateService;


    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    SkillExperienceRepository skillExperienceRepository;
    @Autowired
    SkillUsageRepository skillUsageRepository;
    @Autowired
    CandidateSkillRepository candidateSkillRepository;

    
    @PostMapping(value = "/saveSkill", produces = "application/json")
    public ResponseEntity saveSkillTracker(@RequestBody CandidateSkillDto candidateSkillDto) {
        Integer candidateId = candidateSkillDto.getCandidateId();
        Integer skillId = candidateSkillDto.getSkillId();
        Integer skillExperienceId = candidateSkillDto.getSkillExperienceId();
        Integer skillUsageId = candidateSkillDto.getSkillUsageId();
        boolean certified = candidateSkillDto.isCertified();
        if (candidateId != 0 && skillId != 0 && skillExperienceId != 0 && skillUsageId != 0) {
            Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
            Skill skill = skillRepository.findById(skillId).orElse(null);
            SkillExperience skillExperience = skillExperienceRepository.findById(skillExperienceId).orElse(null);
            SkillUsage skillUsage = skillUsageRepository.findById(skillUsageId).orElse(null);

            CandidateSkill candidateSkill = CandidateSkill.builder()
                    .candidate(candidate)
                    .skill(skill)
                    .skillExperience(skillExperience)
                    .skillUsage(skillUsage)
                    .certified(certified).build();

            candidateSkillRepository.save(candidateSkill);
        } else {
            throw new RestClientException("Id not there");
        }
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{candidateId}")
    public ResponseEntity<List<CandidateSkillDto>> getCandidate(@PathVariable Integer candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        List<CandidateSkill> candidateSkills = candidateService.getCandidateSkills(candidate);
        List<CandidateSkillDto> candidateSkillDtos = new ArrayList<>();
        for (CandidateSkill candidateSkill : candidateSkills) {
            CandidateSkillDto candidateSkillDto = CandidateSkillDto.builder()
                    .candidateId(candidateSkill.getCandidate().getId())
                    .skillId(candidateSkill.getSkill().getId())
                    .skillLabel(candidateSkill.getSkill().getTitle())
                    .skillExperienceId(candidateSkill.getSkillExperience().getId())
                    .skillExperienceLabel(candidateSkill.getSkillExperience().getYears())
                    .skillUsageId(candidateSkill.getSkillUsage().getId())
                    .skillUsageLabel(candidateSkill.getSkillUsage().getUsage())
                    .certified(candidateSkill.isCertified()).build();
            candidateSkillDtos.add(candidateSkillDto);
        }
        return new ResponseEntity<List<CandidateSkillDto>>(candidateSkillDtos, HttpStatus.OK);
    }


}