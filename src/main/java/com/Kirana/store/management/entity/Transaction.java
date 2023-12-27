package com.Kirana.store.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *  Transaction Entity
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double amount;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private Customer customer;
}
