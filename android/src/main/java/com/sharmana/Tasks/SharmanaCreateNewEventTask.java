package com.sharmana.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.sharmana.db.dto.EventDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

import static com.google.api.client.http.HttpStatusCodes.isSuccess;

/**
 * Created by strusov on 11.10.2014.
 */
public class SharmanaCreateNewEventTask extends AsyncTask<Object, Integer, EventDTO> {

    private static final String LOG_TAG = "com.sharmana.Tasks.SharmanaCreateNewEventTask";

    OnObjectDtoLoadedListnerer onObjectDtoLoadedListnerer;

    public SharmanaCreateNewEventTask(OnObjectDtoLoadedListnerer onObjectDtoLoadedListnerer) {
        this.onObjectDtoLoadedListnerer = onObjectDtoLoadedListnerer;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * @param params первым - токен, вторым - эвент
     * @return обновленный эвент (с идешником и смерженный)
     */
    @Override
    protected EventDTO doInBackground(Object... params) {


        HttpClient httpclient = new DefaultHttpClient();
        EventDTO eventDTO = null;
        try {
            String token = (String) params[0];
            EventDTO event = (EventDTO) params[1];

            ObjectMapper mapper = new ObjectMapper();

            HttpPut httpPut = new HttpPut("http://api.sharmana.ru/event/add");
            httpPut.setHeader("Authorization", token);
            httpPut.setEntity(new StringEntity(mapper.writeValueAsString(event), "UTF-8"));
            HttpResponse response = httpclient.execute(httpPut);

            if (isSuccess(response.getStatusLine().getStatusCode())) {

                eventDTO = mapper.readValue(EntityUtils.toString(response.getEntity(), "UTF-8"), EventDTO.class);
                Log.i(LOG_TAG, eventDTO.getId());

            }
        } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        return eventDTO;
    }

    @Override
    protected void onPostExecute(EventDTO result) {
        onObjectDtoLoadedListnerer.objectLoaded(result);
    }
}
