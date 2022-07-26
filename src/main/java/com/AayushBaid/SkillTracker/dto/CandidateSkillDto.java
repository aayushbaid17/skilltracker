package com.AayushBaid.SkillTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CandidateSkillDto {
    private int candidateId;
    private int skillId;
    private String skillLabel;
    private int skillExperienceId;
    private String skillExperienceLabel;
    private int skillUsageId;
    private String skillUsageLabel;
    private boolean certified;
	public Integer getSkillId() {
		// TODO Auto-generated method stub
		return null;
	}
}