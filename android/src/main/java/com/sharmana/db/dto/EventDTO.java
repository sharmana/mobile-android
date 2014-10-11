package com.sharmana.db.dto;

import java.util.List;

/**
 * Created by MandM on 11.10.2014.
 */
public class EventDTO {

    public enum Status {
        OPEN,
        CLOSED
    }

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private String id;
    private String name;
    private String currency;
    private double total;
    private Long created;
    private List<String> emails;
    private List<TransactionDTO> transactions;
    private Status status;

}
