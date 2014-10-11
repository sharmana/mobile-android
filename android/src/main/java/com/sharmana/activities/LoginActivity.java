package com.sharmana.activities;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.sharmana.R;


public class LoginActivity extends Activity implements View.OnClickListener {

    private static final String LOG_TAG = "com.sharmana.LoginActivity";

    private Button bEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(LOG_TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {

        // Enter Button
        bEnter = (Button)findViewById(R.id.bEnter);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/framd.ttf");
        bEnter.setTypeface(typeface);
        bEnter.setOnClickListener(this);
        Log.i(LOG_TAG, "button initiated");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bEnter:
                handleEnter();
                break;
        }
    }

    private void handleEnter() {
        Log.i(LOG_TAG, "Button 'Enter' clicked");
        // TODO:
    }

}
