package com.rewards.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardSummary {

	private String customerId;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;
}
