package com.ms.account.bank.repositorys;

import com.ms.account.bank.models.AccountBank;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBankRepo extends ReactiveMongoRepository<AccountBank, String> {
}
