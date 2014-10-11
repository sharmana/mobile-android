package com.sharmana.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by MandM on 11.10.2014.
 */
public class SharmanaDBHelper extends OrmLiteSqliteOpenHelper {

    private static final String LOG_TAG = "com.sharmana.SharmanaDBHelper";

    private static final String DATABASE_NAME = "SharmanaDB";
    private static final int DATABASE_VERSION = 2;

    private static SharmanaDBHelper helper;
    private static AtomicLong usageCounter = new AtomicLong();

    private static Dao<Group, Integer> groupsDao;

    public SharmanaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(LOG_TAG, "onCreate");
            TableUtils.createTable(connectionSource, Group.class);
        } catch (SQLException e) {
            Log.e(LOG_TAG, "onCreate Failed. "+e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(LOG_TAG, "onUpgrade from "+oldVersion+" to "+newVersion);
            TableUtils.dropTable(connectionSource, Group.class, true);
            Dao<Group, Integer> groups = getDao(Group.class);
            Group group = new Group("New Group");
            groups.create(group);
        } catch (SQLException e) {
            Log.e(LOG_TAG, "onUpgrade Failed. "+e.getMessage());
        }
    }


    public static synchronized SharmanaDBHelper getHelper(Context context) {
        Log.i(LOG_TAG, "getHelper");
        if (helper == null) {
            helper = new SharmanaDBHelper(context);
        }
        usageCounter.incrementAndGet();
        return helper;
    }

    public Dao<Group, Integer> getGroupsDao() throws SQLException{
        if (groupsDao == null) {
            groupsDao = getDao(Group.class);
        }
        return groupsDao;
    }
}
