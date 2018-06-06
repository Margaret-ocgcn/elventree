package com.fhj.elventree.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils {
    public static void main(String[] args) throws IOException {
        String json = "{\"name\":\"zhangsan\", \"age\":20, \"gender\": \"mail\"} ";
        post("http://127.0.0.1:8888/hello/hello",json);
    }
    public static String post(String url, String json) throws IOException {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();
        StringEntity myEntity = new StringEntity(json, ContentType.APPLICATION_JSON);// 构造请求数据
        HttpClient client =HttpClientBuilder.create().build()   ;// new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        post.setEntity(myEntity);
        post.setConfig(requestConfig);
        HttpResponse response = client.execute(post);

        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity resEntity = response.getEntity();
            String message = EntityUtils.toString(resEntity, "utf-8");
            System.out.println(message);
            return message;
        } else {
            System.out.println("请求失败");
            return null;
        }
    }
}
