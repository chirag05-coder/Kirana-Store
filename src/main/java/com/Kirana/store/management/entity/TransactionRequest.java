package com.Kirana.store.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Map;

/**
 * Represents a request entity for a transaction, containing information about the customer
 * initiating the transaction and a map of products to be purchased along with their quantities.
 *
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {

    Customer customer;
    Map<String, Integer>products;
}
