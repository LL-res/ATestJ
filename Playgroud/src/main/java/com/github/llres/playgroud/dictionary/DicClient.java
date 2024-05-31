package com.github.llres.playgroud.dictionary;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class DicClient {
    private HttpClient httpClient;
    private EventBus eventBus;
    public DicClient(EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.register(this);
        httpClient = HttpClients.createDefault();
    }
    @Subscribe
    public void getTranslateContent(String content){
        System.out.println(content);
    }
    public void sendWord(String word){
        String url = "https://od-api-sandbox.oxforddictionaries.com/api/v2";
        String appKey = "f8aa1469c001afd51ea550f7777ea4ac";
        String appID = "6635651f";
        URI entries = null;
        try{
            entries = new URIBuilder(url).setPathSegments("words","en-us").addParameter("q",word).build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        HttpGet httpGet = new HttpGet(entries);
        httpGet.setHeader("app_id",appID);
        httpGet.setHeader("app_key",appKey);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String responseContent = null;
        try {
            responseContent = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(responseContent);
    }
}
