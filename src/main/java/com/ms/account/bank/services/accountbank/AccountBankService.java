package com.ms.account.bank.services.accountbank;

import com.ms.account.bank.models.AccountBank;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountBankService {
    Flux<AccountBank> findAll();
    Mono<AccountBank> findById(String id);
    Mono<AccountBank> save(AccountBank data);
    Mono<Void> deleteById(String id);
}
