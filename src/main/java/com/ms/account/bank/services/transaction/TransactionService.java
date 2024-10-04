package com.ms.account.bank.services.transaction;

import com.ms.account.bank.models.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Flux<Transaction> finsAll();
    Mono<Transaction> findById(String id);
    Mono<Transaction> save(Transaction data);
    Mono<Void> deleteById(String id);
}
