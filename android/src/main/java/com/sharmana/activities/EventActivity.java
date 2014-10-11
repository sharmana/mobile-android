package com.sharmana.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.sharmana.EventAdapter;
import com.sharmana.R;
import com.sharmana.db.dto.EventDTO;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends Activity implements AdapterView.OnItemClickListener {

    private static final String LOG_TAG = "com.sharmana.EventActivity";

    private List<EventDTO> events = null;

    ListView lvEvents;
    Button ibAdd, ibDelete, ibEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        init();
    }


    private void init() {
        initControls();
        initData();
    }

    private void initControls() {
        lvEvents = (ListView) findViewById(R.id.lvEvents);
        ibAdd = (Button) findViewById(R.id.ibAdd);
        //ibDelete = (Button) findViewById(R.id.ibDelete);
        //ibEdit = (Button) findViewById(R.id.ibEdit);
    }

    private void initData() {
        startLoading();
    }

    private void startLoading() {
        Log.i(LOG_TAG, "startLoading()");
        /*
            LoadingEventsTask task = new LoadingEventTask(this);
            task.execute();
          */
        List<EventDTO> events = new ArrayList<EventDTO>();
        EventDTO event;
        event = new EventDTO();
        event.setName("New Name");
        events.add(event);

        event = new EventDTO();
        event.setName("Super Event");
        events.add(event);

        event = new EventDTO();
        event.setName("New Name");
        events.add(event);

        event = new EventDTO();
        event.setName("Super Event");
        events.add(event);
        event = new EventDTO();
        event.setName("New Name");
        events.add(event);

        event = new EventDTO();
        event.setName("Super Event");
        events.add(event);
        event = new EventDTO();
        event.setName("New Name");
        events.add(event);

        event = new EventDTO();
        event.setName("Super Event");
        events.add(event);
        event = new EventDTO();
        event.setName("New Name");
        events.add(event);

        event = new EventDTO();
        event.setName("Super Event");
        events.add(event);
        event = new EventDTO();
        event.setName("New Name");
        events.add(event);

        event = new EventDTO();
        event.setName("Super Event");
        events.add(event);event = new EventDTO();
        event.setName("New Name");
        events.add(event);

        event = new EventDTO();
        event.setName("Super Event");
        events.add(event);



        this.onLoadingSuccess(events);
    }

    public void onLoadingSuccess(List<EventDTO> events) {
        Log.i(LOG_TAG, "onLoadingSuccess()");

        this.events = events;

        ListAdapter adapter = new EventAdapter(this, R.layout.item_event, events);
        lvEvents.setAdapter(adapter);
        lvEvents.setOnItemClickListener(this);
    }

    public void onLoagingFailed() {
        Log.e(LOG_TAG, "We can't load");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event, menu);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((Button)view.findViewById(R.id.bEvent)).setBackgroundResource(R.drawable.gradient_shape);
    }

}
