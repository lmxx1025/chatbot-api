package cn.xiaocheng.chatbot.api.domain.zsxq.model.aggregates;

import cn.xiaocheng.chatbot.api.domain.zsxq.model.res.Resp_data;

public class UnAsweredQuestionAggregates {

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public Resp_data getResp_data() {
        return resp_data;
    }

    public void setResp_data(Resp_data resp_data) {
        this.resp_data = resp_data;
    }

    private  boolean succeeded;
    private Resp_data resp_data;

}
