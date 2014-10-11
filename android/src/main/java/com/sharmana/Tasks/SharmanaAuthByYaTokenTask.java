package com.sharmana.Tasks;

import android.os.AsyncTask;
import android.util.Log;
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


//            POST /token HTTP/1.1
//            Host: oauth.yandex.ru
//            Content-type: application/x-www-form-urlencoded
//            Content-Length: <длина тела запроса>
//
//                    grant_type=authorization_code
//                    & code=<код подтверждения>
//            & client_id=<идентификатор приложения>
//            & client_secret=<пароль приложения>

//    ID: 20880bd1f59c42b48f419e986fbc6b4d
//    Пароль: adfd834d798b479ca49f6d8feb490dfa
//    Callback URL: sharmana://token

            String code = params[0];
//            Uri website = new Uri.Builder()
//                    .scheme("https")
//                    .
//                    .appendPath("://oauth.yandex.ru")
//                    .appendQueryParameter("grant_type", "authorization_code")
//                    .appendQueryParameter("code", code)
//                    .appendQueryParameter("client_id", "20880bd1f59c42b48f419e986fbc6b4d")
//                    .appendQueryParameter("client_secret", "adfd834d798b479ca49f6d8feb490dfa")
//                    .build();
//
//            HttpPost request = new HttpPost(website.toString());
//            HttpResponse response = httpclient.execute(request);

            HttpPost httpPost = new HttpPost("http://api.sharmana.ru/user/auth");
            httpPost.setHeader("Yandex-Token", code);
//            List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
//            nameValuePair.add(new BasicNameValuePair("grant_type", "authorization_code"));
//            nameValuePair.add(new BasicNameValuePair("code", code));
//            nameValuePair.add(new BasicNameValuePair("client_id", "20880bd1f59c42b48f419e986fbc6b4d"));
//            nameValuePair.add(new BasicNameValuePair("client_secret", "adfd834d798b479ca49f6d8feb490dfa"));

//            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));

            HttpResponse response = httpclient.execute(httpPost);
            Log.i(LOG_TAG, "Sharama");
            Log.i(LOG_TAG, response.getStatusLine().toString());

            if(response.getStatusLine().getStatusCode() == 200) {
                Log.i(LOG_TAG, EntityUtils.toString(response.getEntity()));
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