package com.AayushBaid.SkillTracker.repository;

import com.AayushBaid.SkillTracker.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    List<Skill> findBySkillTypeId(int skillTypeId);
}