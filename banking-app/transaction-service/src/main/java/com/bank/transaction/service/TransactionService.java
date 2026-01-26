package com.bank.transaction.service;

import com.bank.transaction.dto.TransferRequest;
import com.bank.transaction.model.Transaction;

public interface TransactionService {
    Transaction transferMoney(TransferRequest request);
}
