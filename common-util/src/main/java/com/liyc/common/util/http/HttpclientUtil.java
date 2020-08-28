package com.liyc.common.util.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author lyc
 * @Date 2020-8-28 9:09
 * @ClassName HttpclientUtil
 * @Description HttpclientUtil工具类
 */
public class HttpclientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpclientUtil.class);

    private static RequestConfig defaultRequestConfig = null;

    private static final Integer TIME_OUT = 30*1000;

    /* 初始化配置 */
    static{
        // 设置超时时间
        defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(TIME_OUT)
                .setConnectTimeout(TIME_OUT)
                .setConnectionRequestTimeout(TIME_OUT)
                .setStaleConnectionCheckEnabled(true)
                .build();
    }

    public static String postWithMap(String url, Map<String, Object> params) throws IOException {

        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = setParams(params);
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);
        //伪装浏览器
        httpPost.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        CloseableHttpResponse response = null;
        String content = null;
        try {
            // 执行请求
            response = httpClient.execute(httpPost);
            // 判断返回状态是否为200
            content = EntityUtils.toString(response.getEntity(), "UTF-8");

        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return content;
    }

    private static List<NameValuePair> setParams(Map<String, Object> params) {
        StringBuilder paramsLogBuilder = new StringBuilder();
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params == null) {
            return nvps;
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                nvps.add(new BasicNameValuePair(key, ""));
                paramsLogBuilder.append("[" + key + "-]");
                continue;
            }
            if (String[].class.isInstance(value)) {
                String[] strArray = (String[]) value;
                for (String str : strArray) {
                    nvps.add(new BasicNameValuePair(key, str));
                }
                paramsLogBuilder.append("[" + key + "- "
                        + Arrays.asList(strArray) + "]");
                continue;
            }
            nvps.add(new BasicNameValuePair(key, value.toString()));
        }
        logger.info("params:" + paramsLogBuilder.toString());
        return nvps;
    }


    //以json形式发送post请求
    public static String postWithJson(String url, String json) throws IOException {
        String returnValue = "这是默认返回值，接口调用失败";
        CloseableHttpClient httpClient = null;
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try{
            //第一步：创建HttpClient对象
            httpClient = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();

            //第二步：创建httpPost对象
            HttpPost httpPost = new HttpPost(url);

            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(json==null?"":json,"utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);

            //第四步：发送HttpPost请求，获取返回值
            returnValue = httpClient.execute(httpPost,responseHandler);

        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //第五步：处理返回值
        return returnValue;
    }

    public static void main(String[] args) throws Exception {
        String url = "http://123.173.79.153:8089/u8cloud/api/uapbd/bddefdoc/insert";
        logger.info("----------------------------");
        String post = postWithJson(url, null);
        logger.info("{}",post);
        logger.info("----------------------------");
    }
}
