package com.example.dbtry.controller;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
public class ImageUrl {
    public static String getArtistImageUrl(String apiUrl) throws IOException {
        String apiKey = "AIzaSyAoM50yYb9inGuFwFFr8DtZO_lHmF_V0uQ";
        String searchEngineId = "72a055435140d4ac0";

        apiUrl += "&key=" + apiKey + "&cx=" + searchEngineId;

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);
        HttpResponse response = httpClient.execute(httpGet);

        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);

        JSONObject jsonResponse = new JSONObject(responseBody);
        if (jsonResponse.has("items")) {
            JSONArray items = jsonResponse.getJSONArray("items");
            if (items.length() > 0) {
                JSONObject firstItem = items.getJSONObject(0);
                return firstItem.getString("link");
            }
        }
        return null;
    }
}
