package com.rewards.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rewards.model.RewardSummary;
import com.rewards.model.Transaction;
import com.rewards.service.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;	
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
	
	private static final Logger log =
            LoggerFactory.getLogger(RewardController.class);

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    
    @PostMapping("/calculate")
    public ResponseEntity<List<RewardSummary>> calculateRewards(@Valid @RequestBody List<@Valid Transaction> transactions) {
    	log.info("Received reward calculation request");
        List<RewardSummary> result = rewardService.calculateRewards(transactions);
        return ResponseEntity.ok(result);
    }
}