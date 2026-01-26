package com.bank.transaction.controller;

import org.springframework.web.bind.annotation.*;
import com.bank.transaction.dto.TransferRequest;
import com.bank.transaction.model.Transaction;
import com.bank.transaction.service.TransactionService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public Transaction transfer(@RequestBody TransferRequest request) {
        return service.transferMoney(request);
    }
}
