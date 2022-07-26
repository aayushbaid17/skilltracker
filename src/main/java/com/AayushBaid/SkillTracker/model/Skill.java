package com.AayushBaid.SkillTracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "SkillTable")
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "skill_type_id", referencedColumnName = "id", nullable = false)
    private SkillType skillType;


    @Column(name = "title")
    private String title;
}