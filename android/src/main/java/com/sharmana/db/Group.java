package com.sharmana.db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by MandM on 11.10.2014.
 */
@DatabaseTable(tableName = "groups")
public class Group {

    public static final String GROUP_NAME_FIELD = "name";

    public Group() {}

    public Group(String name) {
        this.name = name;
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING, columnName = GROUP_NAME_FIELD)
    private String name;
}
