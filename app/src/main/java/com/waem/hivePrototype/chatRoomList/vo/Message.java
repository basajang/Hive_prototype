package com.waem.hivePrototype.chatRoomList.vo;

import com.waem.hivePrototype.chatRoomList.roomEnum.FileType;


import io.realm.RealmObject;

public class Message extends RealmObject {

    private String id;

    /*senderId가 사용자 아이디랑 같으면 자기 메시지*/
    private String senderId;
    // true 일 경우 텍스트 메세지 이외 전부 파일 타입
    private boolean messageType = true;
    // 파일 타입일 경우 fileType. filePath  반드시 필요
    private String fileType;
    private String filepath = "";

    private String text ="";

    private String senderTime;
    private boolean read = false;
    private boolean delete = false;

    /*테스트용 */
    private int itemViewType;

    public Message() {
    }

    public Message(String id, String senderId, boolean messageType, FileType fileType, String filepath,String text, String senderTime, boolean read, boolean delete, int itemViewType) {
        this.id = id;
        this.senderId = senderId;
        this.messageType = messageType;
        this.fileType = fileType.toString();
        this.filepath = filepath;
        this.text=text;
        this.senderTime = senderTime;
        this.text = text;
        this.read = read;
        this.delete = delete;
        this.itemViewType= itemViewType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public boolean isMessageType() {
        return messageType;
    }

    public void setMessageType(boolean messageType) {
        this.messageType = messageType;
    }

    public FileType getFileType() {
        return FileType.valueOf(fileType);
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType.toString();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getSenderTime() {
        return senderTime;
    }

    public void setSenderTime(String senderTime) {
        this.senderTime = senderTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public int getItemViewType() {
        return itemViewType;
    }

    public void setItemViewType(int itemViewType) {
        this.itemViewType = itemViewType;
    }
    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", senderId='" + senderId + '\'' +
                ", messageType=" + messageType +
                ", fileType=" + fileType +
                ", filepath='" + filepath + '\'' +
                ", text='" + text + '\'' +
                ", senderTime='" + senderTime + '\'' +
                ", text='" + text + '\'' +
                ", read=" + read +
                ", delete=" + delete +
                ", itemViewType=" + itemViewType +
                '}';
    }
}
