package com.payclip.assessment.transactionapp.model;

import java.util.Date;
import java.util.UUID;

public class Transaction {
    
    private String id;
    private float amount;
    private String description;
    private Date date;
    private int userId;

    public Transaction(String id, float amount, String description, Date date, int userId) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void generateUUID() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "{" + "transaction_id:" + id + ",amount:" + amount + ",description:" + description + ",date:" + date + ",user_id:" + userId + '}';
    }        
    
}
