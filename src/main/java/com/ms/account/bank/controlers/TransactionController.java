package com.ms.account.bank.controlers;

import com.ms.account.bank.models.Transaction;
import com.ms.account.bank.services.transaction.TransactionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transactions")
@Slf4j
@Tag(name = "Transactions")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @Operation(
            summary = "Listado de transacciones.",
            description = "Listado de todas las transacciones creados en la base de datos.")
    @GetMapping
    public Flux<Transaction> ListTransations(){
        return transactionService.finsAll();
    }

    @Operation(
            summary = "Obtener transaccion.",
            description = "Obtener una transaccion por ID.")
    @GetMapping("/{id}")
    public Mono<Transaction> TransactionById(@PathVariable String id){
        return transactionService.findById(id);
    }

    @Operation(
            summary = "Creación de transaccion.",
            description = "Crear una transaccion en la BD.")
    @PostMapping
    public Mono<Transaction> CreateTransaction(@RequestBody Transaction data){
        return transactionService.save(data);
    }

    @Operation(
            summary = "Actualizar transaccion.",
            description = "Actualizar una transaccion en la BD.")
    @PutMapping("/{id}")
    public Mono<Transaction> UpdateTransaction(@PathVariable String id, @RequestBody Transaction data){
        return transactionService.findById(id).flatMap(t-> {
            t.setId(data.getId());
            t.setImporte(data.getImporte());
            t.setType(data.getType());
            return transactionService.save(t);
        });
    }
    @Operation(
            summary = "Eliminar transaccion.",
            description = "Eliminar una transaccion de la BD.")
    @DeleteMapping("/{id}")
    public Mono<Void> DeleteTransaction(@PathVariable String id){
        return transactionService.deleteById(id);
    }
}
