package com.rewards.service;

import java.util.List;

import com.rewards.model.RewardSummary;
import com.rewards.model.Transaction;

public interface RewardService {
	
	public List<RewardSummary> calculateRewards(List<Transaction> transactions);
	
}
