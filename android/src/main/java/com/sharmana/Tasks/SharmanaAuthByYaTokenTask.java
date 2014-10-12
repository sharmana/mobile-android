package com.sharmana.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.sharmana.db.dto.UserDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by strusov on 11.10.2014.
 */
public class SharmanaAuthByYaTokenTask extends AsyncTask<String, Integer, UserDTO> {

    private static final String LOG_TAG = "com.sharmana.Tasks.SharmanaAuthByYaTokenTask";

    OnObjectDtoLoadedListnerer onObjectDtoLoadedListnerer;

    public SharmanaAuthByYaTokenTask(OnObjectDtoLoadedListnerer onObjectDtoLoadedListnerer) {
        this.onObjectDtoLoadedListnerer = onObjectDtoLoadedListnerer;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected UserDTO doInBackground(String... params) {

        HttpClient httpclient = new DefaultHttpClient();
        UserDTO userDTO = null;
        try {
            String token = params[0];
            HttpPost httpPost = new HttpPost("http://api.sharmana.ru/user/auth");
            httpPost.setHeader("Yandex-Token", token);
            HttpResponse response = httpclient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                userDTO = mapper.readValue(EntityUtils.toString(response.getEntity()), UserDTO.class);
                Log.i(LOG_TAG, userDTO.get_id());

            }
        } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        return userDTO;
    }

    @Override
    protected void onPostExecute(UserDTO result) {
        //super.onPostExecute(result);
        onObjectDtoLoadedListnerer.objectLoaded(result);
    }
}