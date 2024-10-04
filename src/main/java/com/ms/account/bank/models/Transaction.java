package com.ms.account.bank.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;

    @NotEmpty
    private Date date_transaction;

    @NotEmpty
    private Float importe;

    @NotEmpty
    private TypeTransaction type;
}
