package com.waem.hivePrototype.chatRoomList.vo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

    @NotNull
    private String roomId;
    @NotNull
    private String roomName;
    // 채팅방 리스트에 출력될 사용자들 프로필 사진의 list
    private List<String> roomProfilePath = new ArrayList<>();

    private List<Message> messageList = new ArrayList<>();

    // 채팅방 파일 리스트  추후 변경 가능
    private List<RoomFile> fileList = new ArrayList<>();
    @NotNull
    private String wallpapers = "";
    private boolean favorites = false;

    private boolean divisionMessage = true;
    private boolean divisionImage = true;
    private boolean divisionMovie = true;
    private boolean divisionFile = true;

    // 보안 강도 0 = 강함,  1 = 약함
    private int securityStrength = 0;
    // 블라인드 타입 0 = 시간 , 1 = 화면을 벗어날때 , 2 채팅방 닫을 경우
    private int blindType = 0;
    //블라인드 시간 초로 계산
    private int blindTime = 10;

    private boolean noti = true;

    public ChatRoom() {
    }

    public ChatRoom(@NotNull String roomId, @NotNull String roomName, List<String> roomProfilePath, List<Message> messageList, List<RoomFile> fileList, @NotNull String wallpapers, boolean favorites, boolean divisionMessage, boolean divisionImage, boolean divisionMovie, boolean divisionFile, int securityStrength, int blindType, int blindTime, boolean noti) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomProfilePath = roomProfilePath;
        this.messageList = messageList;
        this.fileList = fileList;
        this.wallpapers = wallpapers;
        this.favorites = favorites;
        this.divisionMessage = divisionMessage;
        this.divisionImage = divisionImage;
        this.divisionMovie = divisionMovie;
        this.divisionFile = divisionFile;
        this.securityStrength = securityStrength;
        this.blindType = blindType;
        this.blindTime = blindTime;
        this.noti = noti;
    }

    @NotNull
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(@NotNull String roomId) {
        this.roomId = roomId;
    }

    @NotNull
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(@NotNull String roomName) {
        this.roomName = roomName;
    }

    public List<String> getRoomProfilePath() {
        return roomProfilePath;
    }

    public void setRoomProfilePath(List<String> roomProfilePath) {
        this.roomProfilePath = roomProfilePath;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<RoomFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<RoomFile> fileList) {
        this.fileList = fileList;
    }

    @NotNull
    public String getWallpapers() {
        return wallpapers;
    }

    public void setWallpapers(@NotNull String wallpapers) {
        this.wallpapers = wallpapers;
    }

    public boolean isFavorites() {
        return favorites;
    }

    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public boolean isDivisionMessage() {
        return divisionMessage;
    }

    public void setDivisionMessage(boolean divisionMessage) {
        this.divisionMessage = divisionMessage;
    }

    public boolean isDivisionImage() {
        return divisionImage;
    }

    public void setDivisionImage(boolean divisionImage) {
        this.divisionImage = divisionImage;
    }

    public boolean isDivisionMovie() {
        return divisionMovie;
    }

    public void setDivisionMovie(boolean divisionMovie) {
        this.divisionMovie = divisionMovie;
    }

    public boolean isDivisionFile() {
        return divisionFile;
    }

    public void setDivisionFile(boolean divisionFile) {
        this.divisionFile = divisionFile;
    }

    public int getSecurityStrength() {
        return securityStrength;
    }

    public void setSecurityStrength(int securityStrength) {
        this.securityStrength = securityStrength;
    }

    public int getBlindType() {
        return blindType;
    }

    public void setBlindType(int blindType) {
        this.blindType = blindType;
    }

    public int getBlindTime() {
        return blindTime;
    }

    public void setBlindTime(int blindTime) {
        this.blindTime = blindTime;
    }

    public boolean isNoti() {
        return noti;
    }

    public void setNoti(boolean noti) {
        this.noti = noti;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "roomId='" + roomId + '\'' +
                ", roomName='" + roomName + '\'' +
                ", roomProfilePath=" + roomProfilePath +
                ", messageList=" + messageList +
                ", fileList=" + fileList +
                ", wallpapers='" + wallpapers + '\'' +
                ", favorites=" + favorites +
                ", divisionMessage=" + divisionMessage +
                ", divisionImage=" + divisionImage +
                ", divisionMovie=" + divisionMovie +
                ", divisionFile=" + divisionFile +
                ", securityStrength=" + securityStrength +
                ", blindType=" + blindType +
                ", blindTime=" + blindTime +
                ", noti=" + noti +
                '}';
    }
}
