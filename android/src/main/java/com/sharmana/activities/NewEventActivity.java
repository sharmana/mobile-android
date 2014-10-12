package com.sharmana.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.sharmana.R;
import com.sharmana.db.dto.EventDTO;

import java.util.ArrayList;
import java.util.List;

public class NewEventActivity extends Activity implements View.OnClickListener {

    private static final String LOG_TAG = "NewEventActivity";

    private Button bOk, bNo, bAddEmail;
    private EditText etName;
    private List<EditText> etEmails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        init();
    }

    private void init() {
        initControls();
    }

    private void initControls() {
        bOk = (Button) findViewById(R.id.bOk);
        bNo = (Button) findViewById(R.id.bNo);
        bAddEmail = (Button) findViewById(R.id.bAddEmail);

        bOk.setOnClickListener(this);
        bNo.setOnClickListener(this);
        bAddEmail.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.etName);
        etEmails = new ArrayList<EditText>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_event, menu);
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

    @Override
    public void onClick(View v) {
        Log.i(LOG_TAG, "Button ClicKed");
        switch (v.getId()) {
            case R.id.bOk:
                saveAndClose();
                break;
            case R.id.bNo:
                close();
                break;
            case R.id.bAddEmail:
                addEmail();
                break;
        }
    }

    private void saveAndClose() {
        EventDTO event = new EventDTO();
        event.setName(etName.getText().toString());
        List<String> emails = new ArrayList<String>();
        for (EditText etEmail : etEmails) {
            CharSequence cs = etEmail.getText();
            if (!TextUtils.isEmpty(cs)) {
                emails.add(cs.toString());
            }
        }
        event.setEmails(emails);

        
        finish();
    }

    private void close() {
        finish();
    }



    private void addEmail() {

        LinearLayout llEmails = (LinearLayout) findViewById(R.id.llEmails);
        EditText et = new EditText(this);
        et.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        et.setBackgroundResource(R.drawable.edittext_selector);
        llEmails.addView(et);
    }


}
