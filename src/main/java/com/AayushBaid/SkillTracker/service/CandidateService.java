package com.AayushBaid.SkillTracker.service;

import com.AayushBaid.SkillTracker.model.Candidate;
import com.AayushBaid.SkillTracker.model.CandidateSkill;

import java.util.List;

public interface CandidateService {

    Candidate getCandidate(int candidateId);

    Candidate saveCandidateSkills(CandidateSkill candidateSkill);

    List<CandidateSkill> getCandidateSkills(Candidate candidate);
}