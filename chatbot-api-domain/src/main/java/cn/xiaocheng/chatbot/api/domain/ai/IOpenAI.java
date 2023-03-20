package cn.xiaocheng.chatbot.api.domain.ai;

import cn.xiaocheng.chatbot.api.domain.ai.model.vo.Choices;

import java.io.IOException;

public interface IOpenAI {


    String doChatGPT(String openAikey,String question) throws IOException;
}

