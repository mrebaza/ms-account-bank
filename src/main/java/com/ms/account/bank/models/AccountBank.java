package com.ms.account.bank.models;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "account_bank")
@Data
public class AccountBank {
    @Id
    private String id;

    @NotEmpty
    private String number_acount;

    @NotEmpty
    private Float saldo;

    @NotEmpty
    private TypeAccount type;

    @NotEmpty
    private Date create_account;
}

