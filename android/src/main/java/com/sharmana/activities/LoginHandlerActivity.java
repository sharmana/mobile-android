package com.sharmana.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.sharmana.R;
import com.sharmana.Tasks.OnObjectDtoLoadedListnerer;
import com.sharmana.Tasks.SharmanaAuthByYaTokenTask;
import com.sharmana.db.SharmanaDBHelper;
import com.sharmana.db.dao.UserDao;
import com.sharmana.db.domain.User;
import com.sharmana.db.dto.UserDTO;

import java.sql.SQLException;

public class LoginHandlerActivity extends Activity implements OnObjectDtoLoadedListnerer<UserDTO> {

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

        new SharmanaAuthByYaTokenTask(this).execute(accessToken);
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

    @Override
    public void objectLoaded(UserDTO objectDTO) {
        try {
            UserDao userDao = new UserDao(SharmanaDBHelper.getHelper(this));
            User user = userDao.getByExternalId(objectDTO.get_id());
            if (user == null) {
                userDao.insertUser(objectDTO);
            }
            Log.i(LOG_TAG, String.valueOf(userDao.getAllUser()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
