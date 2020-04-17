package com.waem.hivePrototype.util.requestHelper;

public class BaseResult {
    private int code = 0;
    private String data;
    private String messages = "";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", data='" + data + '\'' +
                ", messages='" + messages + '\'' +
                '}';
    }
}
