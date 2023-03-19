package cn.xiaocheng.chatbot.api.test;



import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ApiTest{
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");


        get.addHeader("cookie","zsxq_access_token=D77C9969-98A1-37B4-5142-921F2A376CAB_4A42B157078AEB75; abtest_env=product; zsxqsessionid=a068363003df527943bb3b4fb8c8b7f2; sajssdk_2015_cross_new_user=1; UM_distinctid=186f44ea928a-0659f5802b0181-26031851-e1000-186f44ea9298d5; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184221842254542%22%2C%22first_id%22%3A%22186f44e3d75612-0b35b8818056cb-26031851-921600-186f44e3d76715%22%2C%22props%22%3A%7B%7D%2C%22%24device_id%22%3A%22186f44e3d75612-0b35b8818056cb-26031851-921600-186f44e3d76715%22%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2ZjQ0ZWFiN2Q0ZjYtMDI5NzRjYzNjZjY2MGM4LTI2MDMxODUxLTkyMTYwMC0xODZmNDRlYWI3ZWE0NiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4NDIyMTg0MjI1NDU0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184221842254542%22%7D%7D");
        get.addHeader("Content-Type","application/json;charset=utf-8");

        HttpRequest request = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");


        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


    public void answer() throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("");
        post.addHeader("","");
        post.addHeader("","");

        String paramJson = "";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("", ""));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}

