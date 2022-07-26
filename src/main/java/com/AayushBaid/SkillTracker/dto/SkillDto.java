package com.AayushBaid.SkillTracker.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class SkillDto implements Serializable {

    private int skillId;

    private String skillTitle;

    private String skillTypeTitle;

}