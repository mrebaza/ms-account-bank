package com.ms.account.bank.services.transaction;

import com.ms.account.bank.models.Transaction;
import com.ms.account.bank.repositorys.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public Flux<Transaction> finsAll() {
        return transactionRepo.findAll();
    }

    @Override
    public Mono<Transaction> findById(String id) {
        return transactionRepo.findById(id);
    }

    @Override
    public Mono<Transaction> save(Transaction data) {
        return transactionRepo.save(data);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionRepo.deleteById(id);
    }
}
