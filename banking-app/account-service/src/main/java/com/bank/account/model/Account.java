package com.bank.account.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String accountType;
    private Double balance;

    public Account() {}

    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public String getAccountType() { return accountType; }
    public Double getBalance() { return balance; }

    public void setId(Long id) { this.id = id; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public void setBalance(Double balance) { this.balance = balance; }
}
