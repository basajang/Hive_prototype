package com.waem.hivePrototype.notification.vo;

import com.waem.hivePrototype.notification.notiEnum.NotiType;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Notification {

    private String id;
    private String title;
    private String userId;
    private String userName;
    private String profilePath = "";
    private Date updateTime;
    @NotNull
    private NotiType notiType = NotiType.MESSAGE;

    public Notification() {
    }

    public Notification(String id, String title, String userId, String userName, String profilePath, Date updateTime, @NotNull NotiType notiType) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.userName = userName;
        this.profilePath = profilePath;
        this.updateTime = updateTime;
        this.notiType = notiType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @NotNull
    public NotiType getNotiType() {
        return notiType;
    }

    public void setNotiType(@NotNull NotiType notiType) {
        this.notiType = notiType;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", profilePath='" + profilePath + '\'' +
                ", updateTime=" + updateTime +
                ", notiType=" + notiType +
                '}';
    }
}
