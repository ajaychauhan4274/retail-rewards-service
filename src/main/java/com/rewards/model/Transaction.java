package com.rewards.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@NotBlank(message = "CustomerId must not be blank")
	private String customerId;
	
	@NotNull(message = "Transaction date must not be null")
    private LocalDate date;
	
	@Positive(message = "Amount must be greater than zero")
    private double amount;
}
