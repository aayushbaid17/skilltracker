package com.AayushBaid.SkillTracker.repository;

import com.AayushBaid.SkillTracker.model.Candidate;
import com.AayushBaid.SkillTracker.model.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Integer> {
    public List<CandidateSkill> findByCandidate(Candidate candidate);
}