package com.shunxin.shunxin_salesman_visit.entity.cliententity;


public class TextMessage extends BaseMessage{
    private String Content;
    private String MsgId;

    public TextMessage(String toUserName, String fromUserName, Long createTime, String msgType, String content, String msgId) {
        super(toUserName,fromUserName,createTime,msgType);
        Content = content;
        MsgId = msgId;
    }

    public TextMessage(){
        super();
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "Content='" + Content + '\'' +
                ", MsgId='" + MsgId + '\'' +
                '}';
    }
}
