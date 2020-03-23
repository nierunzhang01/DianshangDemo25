package com.bw.dianshangdemo25.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.22<p>
 * <p>更改时间：2020.3.22<p>
 */
public class NetUtil {
    private NetUtil(){}

    public static NetUtil getInstance() {
        return NET_UTIL;
    }
    private static final NetUtil NET_UTIL=new NetUtil();
    private String ioToString(InputStream inputStream) throws IOException {
        final byte[] bytes = new byte[1024];
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len=-1;
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes, 0, len);
        }
        final byte[] bytes1 = byteArrayOutputStream.toByteArray();
        final String json = new String(bytes1);
        return json;
    }
    public String doGet(final String httpUrl){
                try {
                    final URL url = new URL(httpUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        final InputStream inputStream = httpURLConnection.getInputStream();
                        final String json = ioToString(inputStream);
                        return json;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
       return null;
    }
}
