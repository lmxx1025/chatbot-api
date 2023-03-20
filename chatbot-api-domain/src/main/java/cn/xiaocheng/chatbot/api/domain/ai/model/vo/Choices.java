package cn.xiaocheng.chatbot.api.domain.ai.model.vo;


public class Choices
{
    private String text;

    private int index;

    private String logprobs;

    private String finish_reason;

    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public int getIndex(){
        return this.index;
    }
    public void setLogprobs(String logprobs){
        this.logprobs = logprobs;
    }
    public String getLogprobs(){
        return this.logprobs;
    }
    public void setFinish_reason(String finish_reason){
        this.finish_reason = finish_reason;
    }
    public String getFinish_reason(){
        return this.finish_reason;
    }

}

