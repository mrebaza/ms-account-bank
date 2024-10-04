package com.ms.account.bank.repositorys;

import com.ms.account.bank.models.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends ReactiveMongoRepository<Transaction, String> {
}
