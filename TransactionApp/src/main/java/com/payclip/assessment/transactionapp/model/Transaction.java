package com.payclip.assessment.transactionapp.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.codehaus.jackson.annotate.JsonProperty;

public class Transaction {
    
    @JsonProperty("transaction_id")
    private String id;
    @JsonProperty("amount")
    private float amount;
    @JsonProperty("description")
    private String description;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("user_id")
    private int userId;

    public Transaction() {
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
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return "{" + "\"transaction_id\":\"" + id + "\",\"amount\":" + amount + ",\"description\":\"" + description + "\",\"date\":\"" + df.format(date) + "\",\"user_id\":" + userId + '}';
    }        
    
}
