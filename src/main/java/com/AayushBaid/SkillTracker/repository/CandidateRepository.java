package com.AayushBaid.SkillTracker.repository;

import com.AayushBaid.SkillTracker.model.Candidate;
import com.AayushBaid.SkillTracker.model.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}