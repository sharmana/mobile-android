package com.sharmana.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.sharmana.db.dto.UserDTO;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
import android.net.Uri;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by strusov on 11.10.2014.
 */
public class SharmanaAuthByYaTokenTask extends AsyncTask<String, Integer, String> {

    private static final String LOG_TAG = "com.sharmana.Tasks.YandexOAuthTokenTask";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        HttpClient httpclient = new DefaultHttpClient();

        try {
            String token = params[0];
            HttpPost httpPost = new HttpPost("http://api.sharmana.ru/user/auth");
            httpPost.setHeader("Yandex-Token", token);
            HttpResponse response = httpclient.execute(httpPost);
            if(response.getStatusLine().getStatusCode() == 200) {
                ObjectMapper mapper = new ObjectMapper();
                UserDTO userDTO = mapper.readValue(EntityUtils.toString(response.getEntity()), UserDTO.class);
                Log.i(LOG_TAG, userDTO.get_id());

            }
        } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

    }
}