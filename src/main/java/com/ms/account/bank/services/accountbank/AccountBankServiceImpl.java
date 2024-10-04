package com.ms.account.bank.services.accountbank;

import com.ms.account.bank.models.AccountBank;
import com.ms.account.bank.repositorys.AccountBankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountBankServiceImpl implements AccountBankService{

    @Autowired
    private AccountBankRepo accountBankRepo;

    @Override
    public Flux<AccountBank> findAll() {
        return accountBankRepo.findAll();
    }

    @Override
    public Mono<AccountBank> findById(String id) {
        return accountBankRepo.findById(id);
    }

    @Override
    public Mono<AccountBank> save(AccountBank data) {
        return accountBankRepo.save(data);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return accountBankRepo.deleteById(id);
    }
}
