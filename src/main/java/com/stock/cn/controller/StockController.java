package com.stock.cn.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stock.cn.entity.StockEntity;
import com.stock.cn.servive.StockService;
import lombok.val;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;
    @PostMapping ("/test")
    public String getStock() throws IOException {
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.声明get请求
        HttpGet httpGet = new HttpGet("https://api.doctorxiong.club/v1/stock/all");
        //3.发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //4.判断状态码
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
            String string = EntityUtils.toString(entity, "utf-8");
            JSONObject jsonObject = JSONObject.parseObject(string);
            final String data = jsonObject.getString("data");
            JSONArray arrays = JSONArray.parseArray(data);

            for (int i = 0; i < arrays.size(); i++) {
                JSONArray arrs  = arrays.getJSONArray(i);
                if (arrs.size()>1){
                    StockEntity stockEntity = new StockEntity();
                    String code = arrs.get(0).toString();
                    code=code.replace("sh","").replace("sz","");
                    stockEntity.setStockCode(code);
                    stockEntity.setStockName(arrs.get(1).toString());
                    stockService.addStock(stockEntity);
                }
            }
            System.out.println(arrays.size());
//            System.out.printf(array.toString());

        }
        //5.关闭资源
        response.close();
        httpClient.close();
        return "ok";
    }
    @PostMapping("/increase")
    public String getStockIncrease() throws IOException {
        String url="https://eq.10jqka.com.cn/gateway/?iwcpro=1";
        HttpPost post = new HttpPost(url);
        CloseableHttpClient client = HttpClientBuilder.create().build();
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("question", "600392涨停基因"));
        parameters.add(new BasicNameValuePair("source", "ths_pc_tongyiban"));
        parameters.add(new BasicNameValuePair("multistage", "{\"is_multistage\":false}"));
        parameters.add(new BasicNameValuePair("channel", "pcxiaochuang"));
        parameters.add(new BasicNameValuePair("entity_info", "{\"device_type\":\"pc\"}"));
        parameters.add(new BasicNameValuePair("kefu_user_id", ""));
        parameters.add(new BasicNameValuePair("kefu_record_id", ""));
        parameters.add(new BasicNameValuePair("user_id", ""));
        parameters.add(new BasicNameValuePair("user_name", "r5mn236d2v"));
        parameters.add(new BasicNameValuePair("version", "2.0"));
        parameters.add(new BasicNameValuePair("control", "ControlCenterV2"));
        parameters.add(new BasicNameValuePair("action", "getAnswer"));
        parameters.add(new BasicNameValuePair("platform", "gphone"));
        parameters.add(new BasicNameValuePair("hangqing", ""));
        parameters.add(new BasicNameValuePair("serverAddr", ""));
        parameters.add(new BasicNameValuePair("deviceid", ""));
        parameters.add(new BasicNameValuePair("model", ""));
        parameters.add(new BasicNameValuePair("build", ""));
        parameters.add(new BasicNameValuePair("sdknum", ""));
        parameters.add(new BasicNameValuePair("appver", ""));
        parameters.add(new BasicNameValuePair("innerver", ""));
        parameters.add(new BasicNameValuePair("for", "ths_am_gphone_login"));
        parameters.add(new BasicNameValuePair("session_id", "bde21c7cc5d4e0866946a817be5338e1"));
        parameters.add(new BasicNameValuePair("add_info", "{\"zhengu\":{},\"command\":{\"needCommand\":true},\"talk\":{\"needIdentity\":true,\"needImg\":true},\"finance\":{\"ans_type\":\"NORMAL\",\"needFurther\":true,\"needFurtherKnow\":true},\"soniu\":{\"needEliminate\":true},\"urp\":{\"keyValue\":{},\"custId\":\"\"}}"));
        parameters.add(new BasicNameValuePair("log_info", "{\"other_info\":{\"eventId\":\"iwencai_app_send_click\",\"ct\":1629008906471},\"other_utype\":\"random\",\"other_uid\":\"ths_pc_tongyiban_cii8vhbgcj8wa69ro4t0md75ah0k8kb0\",\"input_type\":\"typewrite\"}"));
        HttpEntity entity = new UrlEncodedFormEntity(parameters,"utf-8");
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity2 = response.getEntity();
        String string = EntityUtils.toString(entity2);
        JSONObject jsonObject = JSONObject.parseObject(string);

        System.out.println(string);

        return "ok";
    }




}
