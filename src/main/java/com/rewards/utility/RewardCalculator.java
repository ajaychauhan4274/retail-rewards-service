package com.rewards.utility;

public class RewardCalculator {

    public static int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += 2 * (int)(amount - 100);
            points += 50; // 1 point for $50-$100
        } else if (amount > 50) {
            points += (int)(amount - 50);
        }
        return points;
    }
}
