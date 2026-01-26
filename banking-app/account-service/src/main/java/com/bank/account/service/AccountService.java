package com.bank.account.service;

import java.util.List;
import com.bank.account.model.Account;

public interface AccountService {

    Account createAccount(Account account);

    List<Account> getAccountsByCustomerId(Long customerId);
    void withdraw(Long accountId, Double amount);
    void deposit(Long accountId, Double amount);
    
}

