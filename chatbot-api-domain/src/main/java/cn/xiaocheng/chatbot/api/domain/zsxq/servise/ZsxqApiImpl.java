package cn.xiaocheng.chatbot.api.domain.zsxq.servise;

import cn.xiaocheng.chatbot.api.domain.zsxq.IZsxqApi;
import cn.xiaocheng.chatbot.api.domain.zsxq.model.aggregates.UnAsweredQuestionAggregates;
import cn.xiaocheng.chatbot.api.domain.zsxq.model.req.AnswerReq;
import cn.xiaocheng.chatbot.api.domain.zsxq.model.req.ReqData;
import cn.xiaocheng.chatbot.api.domain.zsxq.model.res.AnswerRes;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service



public class ZsxqApiImpl implements IZsxqApi {

    private Logger logger = LoggerFactory.getLogger(ZsxqApiImpl.class);

    @Override
    public UnAsweredQuestionAggregates nonpersonal_commentTopicId(String groupId, String cookie) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/"+groupId+"/topics?scope=all&count=20");


        get.addHeader("cookie",cookie);
        get.addHeader("Content-Type","application/json;charset=utf-8");

        HttpRequest request = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");


        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            logger.info("拉取评论数据。groupId:{} jsonStr{}", groupId, jsonStr);
            return JSON.parseObject(jsonStr,UnAsweredQuestionAggregates.class);
        }else {
            throw new RuntimeException("querUnAnsweredQuestionsTopicId Err Code is"+response.getStatusLine().getStatusCode());
        }
    }

    @Override
    public boolean answer(String groupId, String cookie, String topicId, String text,boolean silenced) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/" + topicId + "/comments");
        post.addHeader("cookie", cookie);
        post.addHeader("Content-Type", "application/json;charset=utf-8");
        post.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");

       /* String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"这个条评论是用接口写的\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";*/
        AnswerReq answerReq = new AnswerReq(new ReqData(text, silenced));
        String paramJson = JSONObject.toJSONString(answerReq);

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            AnswerRes answerRes = JSON.parseObject(jsonStr, AnswerRes.class);
            logger.info("回答问题结果。groupId:{} jsonStr:{}", groupId, jsonStr);
            return answerRes.isSucceed();
        } else {
            throw new RuntimeException("answer Err Code is"+response.getStatusLine().getStatusCode());
        }
    }
}
