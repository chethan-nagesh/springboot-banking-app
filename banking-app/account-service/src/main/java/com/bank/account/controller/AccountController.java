package com.bank.account.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.bank.account.model.Account;
import com.bank.account.service.AccountService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return service.createAccount(account);
    }

    @GetMapping("/customer/{customerId}")
    public List<Account> getAccountsByCustomerId(@PathVariable Long customerId) {
        return service.getAccountsByCustomerId(customerId);
    }
    
    @PutMapping("/withdraw/{id}/{amount}")
    public void withdraw(@PathVariable Long id, @PathVariable Double amount) {
        service.withdraw(id, amount);
    }

    @PutMapping("/deposit/{id}/{amount}")
    public void deposit(@PathVariable Long id, @PathVariable Double amount) {
        service.deposit(id, amount);
    }

}
