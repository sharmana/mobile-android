package com.sharmana.db.domain;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by strusov on 11.10.2014.
 */
@DatabaseTable(tableName = "event")
public class Event {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "name", dataType = DataType.STRING)
    private String name;

    @DatabaseField(columnName = "groupId", foreign = true)
    private Group group;

    @DatabaseField(columnName = "currency", dataType = DataType.STRING)
    private String currency;

    @DatabaseField(columnName = "amount", dataType = DataType.DOUBLE)
    private double amount;

    @DatabaseField(columnName = "externalId", dataType = DataType.STRING)
    private String externalId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type = Event { Id = ").append(id);
        sb.append(", ").append("Name = ").append(name);
        sb.append(", ").append("Group = ").append(group);
        sb.append(", ").append("Currency = ").append(currency);
        sb.append(", ").append("Amount = ").append(amount);
        sb.append(", ").append("ExternalId = ").append(externalId).append(" }");
        return sb.toString();
    }
}
