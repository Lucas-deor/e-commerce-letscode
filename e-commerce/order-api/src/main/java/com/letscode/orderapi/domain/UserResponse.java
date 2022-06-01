package com.letscode.orderapi.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class UserResponse {

    private String id;
    private String name;
    private BigDecimal balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
