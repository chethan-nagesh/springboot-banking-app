package com.bank.transaction.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bank.transaction.dto.TransferRequest;
import com.bank.transaction.exception.TransactionFailedException;
import com.bank.transaction.model.Transaction;
import com.bank.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction transferMoney(TransferRequest request) {

        try {
            restTemplate.put(
                "http://localhost:8083/api/accounts/withdraw/{id}/{amount}",
                null,
                request.getFromAccountId(),
                request.getAmount()
            );

            restTemplate.put(
                "http://localhost:8083/api/accounts/deposit/{id}/{amount}",
                null,
                request.getToAccountId(),
                request.getAmount()
            );

            Transaction tx = new Transaction();
            tx.setFromAccountId(request.getFromAccountId());
            tx.setToAccountId(request.getToAccountId());
            tx.setAmount(request.getAmount());
            tx.setStatus("SUCCESS");
            tx.setTimestamp(LocalDateTime.now());

            return repository.save(tx);

        } catch (Exception e) {
            throw new TransactionFailedException("Transaction failed");
        }
    }

}
