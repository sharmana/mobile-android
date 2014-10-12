package com.sharmana.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sharmana.db.domain.*;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by MandM on 11.10.2014.
 */
public class SharmanaDBHelper extends OrmLiteSqliteOpenHelper {

    private static final String LOG_TAG = "com.sharmana.SharmanaDBHelper";

    private static final String DATABASE_NAME = "SharmanaDB";
    private static final int DATABASE_VERSION = 18;

    private static SharmanaDBHelper helper;
    private static AtomicLong usageCounter = new AtomicLong();

    private static Dao<User, Integer> usersDao;
    private static Dao<Group, Integer> groupsDao;
    private static Dao<Event, Integer> eventsDao;
    private static Dao<Transaction, Integer> transactionsDao;
    private static Dao<Email, Integer> emailDao;

    public SharmanaDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(LOG_TAG, "onCreate");

            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Group.class);
            TableUtils.createTable(connectionSource, Event.class);
            TableUtils.createTable(connectionSource, Transaction.class);
            TableUtils.createTable(connectionSource, Email.class);
        } catch (SQLException e) {
            Log.e(LOG_TAG, "onCreate Failed. "+e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Log.i(LOG_TAG, "before try onUpgrade from "+oldVersion+" to "+newVersion);
        try {
            Log.i(LOG_TAG, "onUpgrade from "+oldVersion+" to "+newVersion);

            TableUtils.dropTable(connectionSource, Group.class, true);
            Log.i(LOG_TAG, "drop grpup");
            TableUtils.dropTable(connectionSource, User.class, true);
            Log.i(LOG_TAG, "drop user");
            TableUtils.dropTable(connectionSource, Event.class, true);
            Log.i(LOG_TAG, "drop event");
            TableUtils.dropTable(connectionSource, Transaction.class, true);
            Log.i(LOG_TAG, "drop transaction");
            TableUtils.dropTable(connectionSource, Email.class, true);
            Log.i(LOG_TAG, "drop emails");

            onCreate(database, connectionSource);
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

    public Dao<Event, Integer> getEventsDao() throws SQLException{
        if (eventsDao == null) {
            eventsDao = getDao(Event.class);
        }
        return eventsDao;
    }

    public Dao<Transaction, Integer> getTransactionsDao() throws SQLException{
        if (transactionsDao == null) {
            transactionsDao = getDao(Transaction.class);
        }
        return transactionsDao;
    }

    public Dao<User, Integer> getUsersDao() throws SQLException{
        if (usersDao == null) {
            usersDao = getDao(User.class);
        }
        return usersDao;
    }

    public Dao<Email, Integer> getEmailDao() throws SQLException {
        if (emailDao == null) {
            emailDao = getDao(Email.class);
        }
        return emailDao;
    }
}
