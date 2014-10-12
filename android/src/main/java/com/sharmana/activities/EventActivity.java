package com.sharmana.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.sharmana.EventAdapter;
import com.sharmana.R;
import com.sharmana.Tasks.GetAllEventsTask;
import com.sharmana.Tasks.OnObjectDtoLoadedListnerer;
import com.sharmana.db.SharmanaDBHelper;
import com.sharmana.db.dao.UserDao;
import com.sharmana.db.domain.User;
import com.sharmana.db.dto.EventDTO;
import com.sharmana.db.dto.EventsDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventActivity extends Activity implements OnObjectDtoLoadedListnerer<EventsDTO>, View.OnClickListener {

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

        ibAdd.setOnClickListener(this);
    }

    private void initData() {
        startLoading();
    }

    private void startLoading() {
        Log.i(LOG_TAG, "startLoading()");

        SharmanaDBHelper helper = SharmanaDBHelper.getHelper(this);
        try {
            User user = new UserDao(helper).getActiveUser();
            GetAllEventsTask task = new GetAllEventsTask(this);
            task.execute(user.getExternalId());
        } catch (SQLException e) {
            Log.e(LOG_TAG, "Can't load user or can't connect to db");
        }


        /*List<EventDTO> events = new ArrayList<EventDTO>();
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



        this.onLoadingSuccess(events);*/
    }

    public void onLoadingSuccess(EventsDTO events) {
        Log.i(LOG_TAG, "onLoadingSuccess()");

        this.events = (List<EventDTO>)events;

        ListAdapter adapter = new EventAdapter(this, R.layout.item_event, this.events);
        lvEvents.setAdapter(adapter);
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
    public void objectLoaded(EventsDTO objectDTO) {

        Log.i(LOG_TAG, "objectLoaded "+objectDTO);
        if (objectDTO != null) {
            for (EventDTO event : objectDTO) {
               Log.i(LOG_TAG, "Event_Name: "+event.getName());
            }
            this.onLoadingSuccess(objectDTO);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibAdd:
                addNewEvent();
                break;
        }
    }

    private void addNewEvent() {
        Intent intent = new Intent(this, NewEventActivity.class);
        startActivity(intent);
    }
}
