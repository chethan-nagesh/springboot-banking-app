package com.bank.account.service;

import java.util.List;

//import java.util.List;
import org.springframework.stereotype.Service;

import com.bank.account.exception.AccountNotFoundException;
import com.bank.account.exception.InsufficientBalanceException;
import com.bank.account.model.Account;
import com.bank.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account createAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public List<Account> getAccountsByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }
    
    
    @Override
    public void withdraw(Long accountId, Double amount) {

        System.out.println("WITHDRAW CALLED");
        System.out.println("Account ID: " + accountId);
        System.out.println("Amount: " + amount);

        Account account = repository.findById(accountId)
            .orElseThrow(() -> new AccountNotFoundException("Account NOT FOUND with id "+ accountId));

        System.out.println("Current balance: " + account.getBalance());

        if (account.getBalance() == null) {
            throw new RuntimeException("Balance is NULL in DB");
        }

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        repository.save(account);

        System.out.println("Withdraw SUCCESS");
    }




    @Override
    public void deposit(Long accountId, Double amount) {
        Account account = repository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() == null) {
            account.setBalance(0.0);
        }

        account.setBalance(account.getBalance() + amount);
        repository.save(account);
    }


}
