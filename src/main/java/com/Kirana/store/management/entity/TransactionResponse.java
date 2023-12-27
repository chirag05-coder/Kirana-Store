package com.Kirana.store.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Represents a response entity for a transaction, providing details about the outcome
 * of a transaction, including a list of purchased products, remaining balance and a message

 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

    Map<String, Integer> productList;

    double remainingBalance;

    String message;

}
