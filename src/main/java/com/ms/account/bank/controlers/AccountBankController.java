package com.ms.account.bank.controlers;

import com.ms.account.bank.models.AccountBank;
import com.ms.account.bank.services.accountbank.AccountBankServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/account-bank")
@Slf4j
@Tag(name = "AccountBanks")
public class AccountBankController {

    @Autowired
    private AccountBankServiceImpl accountBankService;

    @Operation(
            summary = "Listado de acuentas bancarias.",
            description = "Listado de todas las cuentas bancarias en la base de datos.")
    @GetMapping
    public Flux<AccountBank> ListAccountBank(){
        return accountBankService.findAll();
    }

    @Operation(
            summary = "Obtener cuenta.",
            description = "Obtener cuenta por ID.")
    @GetMapping("/{id}")
    public Mono<AccountBank> AccountBankById(@PathVariable String id){
        return accountBankService.findById(id);
    }

    @Operation(
            summary = "Creación de cuenta.",
            description = "Crear un cuenta en la BD.")
    @PostMapping
    public Mono<AccountBank> CreateAccountBank(@RequestBody AccountBank data){
        return accountBankService.save(data);
    }

    @Operation(
            summary = "Actualizar cuenta.",
            description = "Actualizar un cuenta en la BD.")
    @PutMapping("/{id}")
    public Mono<AccountBank> UpdateAccountBank(@PathVariable String id, @RequestBody AccountBank data){
        return accountBankService.findById(id).flatMap(a -> {
            a.setId(data.getId());
            a.setNumber_acount(data.getNumber_acount());
            a.setSaldo(data.getSaldo());
            a.setType(data.getType());
            return accountBankService.save(a);
        });
    }

    @Operation(
            summary = "Eliminar cuenta.",
            description = "Eliminar un cuenta de la BD.")
    @DeleteMapping("/{id}")
    public Mono<Void> DeleteAcountBank(@PathVariable String id){
        return accountBankService.deleteById(id);
    }
}
