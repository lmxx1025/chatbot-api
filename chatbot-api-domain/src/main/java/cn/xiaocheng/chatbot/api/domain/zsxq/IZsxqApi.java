package cn.xiaocheng.chatbot.api.domain.zsxq;

import cn.xiaocheng.chatbot.api.domain.zsxq.model.aggregates.UnAsweredQuestionAggregates;

import java.io.IOException;

public interface IZsxqApi {

    UnAsweredQuestionAggregates nonpersonal_commentTopicId(String groupId, String cookie) throws IOException;

    boolean answer(String groupId,String cookie,String topicId,String text,boolean silenced) throws IOException;

}
