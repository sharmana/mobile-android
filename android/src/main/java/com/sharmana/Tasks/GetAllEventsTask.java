package com.sharmana.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.sharmana.db.dto.EventDTO;
import com.sharmana.db.dto.EventsDTO;
import com.sharmana.db.dto.UserDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by strusov on 11.10.2014.
 */
public class GetAllEventsTask extends AsyncTask<String, Integer, EventsDTO> {

    private static final String LOG_TAG = "com.sharmana.Tasks.GetAllEventsTask";

    OnObjectDtoLoadedListnerer onObjectDtoLoadedListnerer;

    public GetAllEventsTask(OnObjectDtoLoadedListnerer onObjectDtoLoadedListnerer) {
        this.onObjectDtoLoadedListnerer = onObjectDtoLoadedListnerer;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected EventsDTO doInBackground(String... params) {

        HttpClient httpclient = new DefaultHttpClient();
        EventsDTO eventDTO = null;
        try {
            String token = params[0];
            HttpGet httpGet = new HttpGet("http://api.sharmana.ru/events/my");
            httpGet.setHeader("Authorization", token);
            HttpResponse response = httpclient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                String responseResult = EntityUtils.toString(response.getEntity(), "UTF-8");
                Log.i(LOG_TAG, "response for events: "+responseResult);
                eventDTO = mapper.readValue(responseResult, EventsDTO.class);
                Log.i(LOG_TAG, eventDTO.toString());

            }
        } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        return eventDTO;
    }

    @Override
    protected void onPostExecute(EventsDTO result) {
        //super.onPostExecute(result);
        onObjectDtoLoadedListnerer.objectLoaded(result);
    }
}
