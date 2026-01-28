package com.rewards;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rewards.model.RewardSummary;
import com.rewards.model.Transaction;
import com.rewards.serviceImpl.RewardServiceImpl;

public class RewardServiceTest {

    private final RewardServiceImpl service = new RewardServiceImpl();

    @Test
    void testCalculateRewards() {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("C1", LocalDate.of(2025, 10, 5), 120),
                new Transaction("C1", LocalDate.of(2025, 10, 15), 75)
        );

        List<RewardSummary> result = service.calculateRewards(transactions);

        assertEquals(1, result.size());
        assertEquals(115, result.get(0).getTotalPoints());
    }
}
