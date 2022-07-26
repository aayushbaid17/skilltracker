package com.AayushBaid.SkillTracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.springframework.lang.NonNull;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "CandidateSkillTable")
public class CandidateSkill implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
 
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false)
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "skill_experience_id", referencedColumnName = "id", nullable = false)
    private SkillExperience skillExperience;

    @ManyToOne
    @JoinColumn(name = "skill_usage_id", referencedColumnName = "id", nullable = false)
    private SkillUsage skillUsage;

    private boolean certified;

}
