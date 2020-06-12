package com.sy.common;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    private static final int CONNECT_TIMEOUT = 60;

    private static final int READ_TIMEOUT = 100;

    private static final int WRITE_TIMEOUT = 60;

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build();

    private static final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

    public static String httpGet(String url) throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        return doRequest(request);
    }

    public static InputStream httpDownGet(String url) throws Exception {
        Request request = new Request.Builder().url(url).get().build();
        ResponseBody body = client.newCall(request).execute().body();
        InputStream in = body.byteStream();
        return in;
    }

    public static String httpFormPost(String url, Map<String, String> map) throws IOException {
        Request request = getRequest(url, map);

        return doRequest(request);
    }
    public static String httpFormPostHeader(String url, Map<String, String> map, String header) throws IOException {
        Request request = getRequestAddHeader(url, map,header);
        return doRequest(request);
    }

    public static String httpJsonPost(String url, String json) throws IOException{
        RequestBody requestBody = FormBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return doRequest(request);
    }

    private static Request getRequest(String url, Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            if (next != null) {
                String value = next.getValue();
                if (!StringUtils.isEmpty(value)) {
                    builder.add(next.getKey(), value);
                }
            }
        }
        FormBody formBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        return request;

    }
    private static Request getRequestAddHeader(String url, Map<String, String> map,String header) {
        FormBody.Builder builder = new FormBody.Builder();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            if (next != null) {
                String value = next.getValue();
                if (!StringUtils.isEmpty(value)) {
                    builder.add(next.getKey(), value);
                }
            }
        }
        FormBody formBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .addHeader("authorization",header)
                .build();

        return request;

    }


    private static String doRequest(Request request) throws IOException {
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException(response.toString());
        }
    }

}
