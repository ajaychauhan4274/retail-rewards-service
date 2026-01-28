package com.rewards.serviceImpl;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rewards.model.RewardSummary;
import com.rewards.model.Transaction;
import com.rewards.service.RewardService;
import com.rewards.utility.RewardCalculator;

@Service
public class RewardServiceImpl implements RewardService{

	private static final Logger log =
            LoggerFactory.getLogger(RewardServiceImpl.class);
	
	public List<RewardSummary> calculateRewards(List<Transaction> transactions) {
	    Map<String, Map<String, Integer>> customerMonthlyPoints = new HashMap<>();

	    log.info("Starting reward calculation for {} transactions", transactions.size());

	    for (Transaction tx : transactions) {
	        String customerId = tx.getCustomerId();
	        String monthName = tx.getDate().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	        int points = RewardCalculator.calculatePoints(tx.getAmount());

	        log.debug("Customer: {}, Month: {}, Amount: {}, Points: {}",
	                customerId, monthName, tx.getAmount(), points);

	        // Add points to the customer's monthly map
	        Map<String, Integer> monthlyPoints = customerMonthlyPoints.computeIfAbsent(customerId, k -> new HashMap<>());
	        monthlyPoints.merge(monthName, points, Integer::sum);
	    }

	    List<RewardSummary> rewardSummaries = new ArrayList<>();
	    for (Map.Entry<String, Map<String, Integer>> customerEntry : customerMonthlyPoints.entrySet()) {
	        String customerId = customerEntry.getKey();
	        Map<String, Integer> monthlyPoints = customerEntry.getValue();
	        int totalPoints = monthlyPoints.values().stream().mapToInt(Integer::intValue).sum();

	        rewardSummaries.add(new RewardSummary(customerId, monthlyPoints, totalPoints));
	    }

	    return rewardSummaries;
	}

}
