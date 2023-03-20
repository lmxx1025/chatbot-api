package cn.xiaocheng.chatbot.api.domain.zsxq.model.res;

import cn.xiaocheng.chatbot.api.domain.zsxq.model.vo.Topic;

import java.util.List;

public class Resp_data {
    private List<Topic> topic;

    public List<Topic> getTopic() {
        return topic;
    }

    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }
}
