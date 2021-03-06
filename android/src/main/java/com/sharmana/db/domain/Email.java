package com.sharmana.db.domain;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by strusov on 12.10.2014.
 */
@DatabaseTable(tableName = "email")
public class Email {

    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField(columnName = "email", dataType = DataType.STRING)
    private String email;

    @DatabaseField(columnName = "eventId", foreign = true, foreignAutoRefresh = true)
    private Event event;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


    public Email() {}
    public Email(String email) {
        this.email = email;
    }

}
