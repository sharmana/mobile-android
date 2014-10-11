package com.sharmana.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.sharmana.db.dto.EventDTO;
import com.sharmana.db.dto.EventsDTO;
import com.sharmana.db.dto.UserDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
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
            HttpPost httpPost = new HttpPost("http://api.sharmana.ru/event/my");
            httpPost.setHeader("Authorization", token);
            HttpResponse response = httpclient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                eventDTO = mapper.readValue(EntityUtils.toString(response.getEntity()), EventsDTO.class);
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
