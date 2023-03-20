package cn.xiaocheng.chatbot.api.test;


import cn.xiaocheng.chatbot.api.domain.ai.IOpenAI;
import cn.xiaocheng.chatbot.api.domain.zsxq.IZsxqApi;
import cn.xiaocheng.chatbot.api.domain.zsxq.model.aggregates.UnAsweredQuestionAggregates;
import cn.xiaocheng.chatbot.api.domain.zsxq.model.vo.Topic;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api.groupId}")
    private String groupId;
    @Value("${chatbot-api.cookie}")
    private  String cookie;
    @Value("${chatbot-api.openAikey}")
    private  String openAikey;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;


    @Test
    public void test_zsxqApi() throws IOException {
        UnAsweredQuestionAggregates unAsweredQuestionAggregates = zsxqApi.nonpersonal_commentTopicId(groupId, cookie);
        logger.info("测试结果: {}",JSON.toJSONString(unAsweredQuestionAggregates));

        List<Topic> topic = unAsweredQuestionAggregates.getResp_data().getTopic();
        for(Topic topic1 : topic){
            String topic_id = topic1.getTopic_id();
            String text = topic1.getQuestion().getText();
            logger.info("topic_id:{} text:{}",topic_id,text);

            //回答问题
            zsxqApi.answer(groupId,cookie,topic_id,text,false);
        }
    }

    //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
    @Test
    public void

    test_openAI() throws IOException{
        String response = openAI.doChatGPT(openAikey,"写一个双栈实现队列");

        logger.info("测试结果: {}",response);
    }

}
