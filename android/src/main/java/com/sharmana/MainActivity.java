package com.sharmana;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.j256.ormlite.dao.Dao;
import com.sharmana.db.Group;
import com.sharmana.db.SharmanaDBHelper;

import java.sql.SQLException;


public class MainActivity extends ActionBarActivity {

    private static final String LOG_TAG = "com.sharmana.MainActivity";

    SharmanaDBHelper helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        try {
            Dao<Group, Integer> groups = getSharmanaHelper().getGroupsDao();
            groups.queryForAll();
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
        // automatically handle clicks on the Home/Up button, so long
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
        return helper;
    }
}
