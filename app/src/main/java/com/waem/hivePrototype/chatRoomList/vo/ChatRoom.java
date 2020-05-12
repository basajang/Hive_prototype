package com.waem.hivePrototype.chatRoomList.vo;

import com.waem.hivePrototype.peopleList.vo.People;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ChatRoom extends RealmObject {

    /*기본키로 사용하기 위해선 Primary key 어노테이션을 사용해야함*/
    @NotNull
    @PrimaryKey
    private String roomId = UUID.randomUUID().toString();
    /*채팅방 이름*/
    @NotNull
    private String roomName;
    // 채팅방 리스트에 출력될 사용자들 프로필 사진의 list
    private RealmList<String> roomProfilePath = new RealmList<>();
    //채팅방 내의 메세지 리스트
    private RealmList<Message> messageList;
    // 채팅방 파일 리스트  추후 변경 가능
    private RealmList<RoomFile> fileList;
    // 채팅방 참가자 리스트
    private RealmList<People> peopleList;
    // 채팅방 배경 화면
    @NotNull
    private String wallpapers = "";
    // 즐겨 찾기 여부
    private boolean favorites = false;

    // 각각의 분할 여부
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

    // 알림
    private boolean noti = true;

    public ChatRoom() {
    }

    public ChatRoom(@NotNull String roomName, RealmList<String> roomProfilePath, RealmList<Message> messageList, RealmList<RoomFile> fileList, @NotNull String wallpapers, boolean favorites, boolean divisionMessage, boolean divisionImage, boolean divisionMovie, boolean divisionFile, int securityStrength, int blindType, int blindTime, boolean noti) {
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

    @NotNull
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(@NotNull String roomName) {
        this.roomName = roomName;
    }

    public RealmList<String> getRoomProfilePath() {
        return roomProfilePath;
    }

    public void setRoomProfilePath(RealmList<String> roomProfilePath) {
        this.roomProfilePath = roomProfilePath;
    }

    public RealmList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(RealmList<Message> messageList) {
        this.messageList = messageList;
    }

    public RealmList<RoomFile> getFileList() {
        return fileList;
    }

    public void setFileList(RealmList<RoomFile> fileList) {
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
