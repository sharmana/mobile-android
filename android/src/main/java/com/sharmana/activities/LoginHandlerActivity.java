package com.sharmana.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.sharmana.R;
import com.sharmana.Tasks.SharmanaAuthByYaTokenTask;

public class LoginHandlerActivity extends ActionBarActivity {

    private static final String LOG_TAG = "com.sharmana.activities.LoginHandlerActivity";

//    ID: 20880bd1f59c42b48f419e986fbc6b4d
//    Пароль: adfd834d798b479ca49f6d8feb490dfa
//    Callback URL: sharmana://token
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_handler);

        Log.i(LOG_TAG, "Iam here");

        Intent intent = getIntent();

//        String code = intent.getData().getQueryParameter("token");
        Log.i(LOG_TAG, intent.getDataString());
        String url = intent.getDataString();
        int start = url.indexOf("access_token=") + "access_token=".length();
        int stop = url.indexOf("&", start);
        String accessToken = url.substring(start, stop);
        Log.i(LOG_TAG, accessToken);

        new SharmanaAuthByYaTokenTask().execute(accessToken);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login_handler, menu);
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
}
