package com.sharmana.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import com.sharmana.R;
import com.sharmana.TransactionAdapter;
import com.sharmana.db.SharmanaDBHelper;
import com.sharmana.db.dao.EventDao;
import com.sharmana.db.domain.Transaction;
import com.sharmana.db.dto.TransactionDTO;

import java.util.List;

public class TransactionActivity extends Activity {

    private static final String LOG_TAG = "com.sharmana.TransactionActivity";

    private String externalId;
    private List<Transaction> transactions;

    private ListView lvTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        init();
    }

    private void init() {
       initEvent();
       initControls();
    }

    private void initEvent() {
        String externalId = getIntent().getStringExtra("ExternalEventId");
        Log.i(LOG_TAG, "external id = "+externalId);
        SharmanaDBHelper helper = SharmanaDBHelper.getHelper(this);
        try {
            transactions = new EventDao(helper).getTransactionByExternalEventId(externalId);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Can't load transactions");
            finish();
        }
    }

    private void initControls() {
        lvTransactions = (ListView) findViewById(R.id.lvTransactions);
        Log.i(LOG_TAG, "Size of transactions:  "+transactions);
        if (transactions != null && transactions.size() > 0) {
            TransactionAdapter adapter = new TransactionAdapter(this, R.layout.item_transaction, transactions);
            lvTransactions.setAdapter(adapter);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.transaction, menu);
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
}
