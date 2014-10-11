package com.sharmana.db.domain;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by strusov on 11.10.2014.
 */
@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING, columnName = "name")
    private String name;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING, columnName = "email")
    private String email;

    @DatabaseField(dataType = DataType.STRING, columnName = "yandexId")
    private String yandexId;

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

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYandexId() {
        return yandexId;
    }

    public void setYandexId(String yandexId) {
        this.yandexId = yandexId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type = User { Id = ").append(id);
        sb.append(", ").append("Name = ").append(name);
        sb.append(", ").append("Email = ").append(email);
        sb.append(", ").append("YandexId = ").append(yandexId);
        sb.append(", ").append("ExternalId = ").append(externalId).append(" }");
        return sb.toString();
    }
}
