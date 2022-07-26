package com.AayushBaid.SkillTracker.service.impl;

import com.skilltracker.model.Candidate;
import com.skilltracker.model.CandidateSkill;
import com.AayushBaid.SkillTracker.repository.CandidateRepository;
import com.AayushBaid.SkillTracker.repository.CandidateSkillRepository;
import com.AayushBaid.SkillTracker.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    CandidateSkillRepository candidateSkillRepository;

    @Override
    @Transactional
    public Candidate getCandidate(int candidateId) {
        return candidateId;
    }

    @Override
    public Candidate saveCandidateSkills(CandidateSkill candidateSkill) {
        return null;
    }

    @Override
    public List<CandidateSkill> getCandidateSkills(Candidate candidate) {
        return candidateSkillRepository.findByCandidate(candidate);
    }
}