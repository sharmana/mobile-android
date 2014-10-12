package com.sharmana.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.sharmana.db.dto.EventDTO;
import com.sharmana.db.dto.EventsDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by strusov on 12.10.2014.
 */
public class AddEventTask extends AsyncTask<String, Integer, EventDTO> {

    private static final String LOG_TAG = "com.sharmana.Tasks.AddEventTask";

    OnObjectDtoLoadedListnerer onObjectDtoLoadedListnerer;

    public AddEventTask(OnObjectDtoLoadedListnerer onObjectDtoLoadedListnerer) {
        this.onObjectDtoLoadedListnerer = onObjectDtoLoadedListnerer;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected EventDTO doInBackground(String... params) {

        HttpClient httpclient = new DefaultHttpClient();
        EventDTO eventDTO = null;
        try {
            String token = params[0];
            String eventString = params[1];
            HttpPut httpPut = new HttpPut("http://api.sharmana.ru/event/add");
            httpPut.setHeader("Authorization", token);
            httpPut.setHeader("Content-type", "application/json");
            httpPut.setEntity(new StringEntity(eventString));
            HttpResponse response = httpclient.execute(httpPut);
            if(response.getStatusLine().getStatusCode() == 201) {
                ObjectMapper mapper = new ObjectMapper();
                eventDTO = mapper.readValue(EntityUtils.toString(response.getEntity()), EventDTO.class);
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        return eventDTO;
    }

    @Override
    protected void onPostExecute(EventDTO result) {
        //super.onPostExecute(result);
        onObjectDtoLoadedListnerer.objectLoaded(result);
    }
}
