package com.sharmana;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.j256.ormlite.dao.Dao;
import com.sharmana.db.domain.Event;
import com.sharmana.db.domain.Group;
import com.sharmana.db.SharmanaDBHelper;
import com.sharmana.db.domain.Transaction;

import java.sql.SQLException;


public class MainActivity extends ActionBarActivity {

    private static final String LOG_TAG = "com.sharmana.MainActivity";

    SharmanaDBHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        try {
            Dao<Group, Integer> groupsDao = getSharmanaHelper().getGroupsDao();
            Dao<Event, Integer> eventDao = getSharmanaHelper().getEventsDao();
            Dao<Transaction, Integer> transactionsDao = getSharmanaHelper().getTransactionsDao();

//            Group g = new Group("MyGroup");
//            groupsDao.create(g);
//
//            Event e = new Event();
//            e.setName("MyEvent");
//            e.setGroup(g);
//            e.setCurrency("RUB");
//            e.setAmount(100.0);
//            eventDao.create(e);
//
//            Transaction t = new Transaction();
//            t.setEvent(e);
//            t.setFrom("trusov");
//            t.setTo("maslov");
//            t.setCurrency("RUB");
//            t.setAmount(100.0);
//            transactionsDao.create(t);
//            groups.delete(groups.queryForAll().get(0));
//            eventDao.delete(eventDao.queryForAll().get(0));
//            transactionsDao.delete(transactionsDao.queryForAll().get(0));

            Log.i(LOG_TAG, groupsDao.queryForAll().toString());
            Log.i(LOG_TAG, eventDao.queryForAll().toString());
            Log.i(LOG_TAG, transactionsDao.queryForAll().toString());
        } catch (SQLException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button_idle, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private SharmanaDBHelper getSharmanaHelper() {
        if (helper == null) {
            helper = SharmanaDBHelper.getHelper(this);
        }
//        Group g = new Group();
        return helper;
    }
}
