package com.sharmana.db.domain;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by strusov on 11.10.2014.
 */
public class Transaction {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "eventId", foreign = true, foreignAutoRefresh = true)
    private Event event;

    @DatabaseField(columnName = "from", dataType = DataType.STRING)
    private String from;

    @DatabaseField(columnName = "to", dataType = DataType.STRING)
    private String to;

    @DatabaseField(columnName = "currency", dataType = DataType.STRING)
    private String currency;

    @DatabaseField(columnName = "amount", dataType = DataType.DOUBLE)
    private double amount;

    @DatabaseField(columnName = "externalId", dataType = DataType.STRING)
    private String externalId;

    @DatabaseField(columnName = "date", dataType = DataType.LONG)
    private Long date;

    @DatabaseField(columnName = "comment", dataType = DataType.STRING)
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getExternalId() {
        return externalId;
    }
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Long getDate() {
        return date;
    }
    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type = Transaction { Id = ").append(id);
        sb.append(", ").append("Event =").append(event);
        sb.append(", ").append("From = ").append(from);
        sb.append(", ").append("To = ").append(to);
        sb.append(", ").append("Currency = ").append(currency);
        sb.append(", ").append("Amount = ").append(amount);
        sb.append(", ").append("Date = ").append(date);
        sb.append(", ").append("ExternalId = ").append(externalId).append(" }");
        return sb.toString();
    }
}
