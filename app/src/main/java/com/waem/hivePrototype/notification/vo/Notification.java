package com.waem.hivePrototype.notification.vo;

import com.waem.hivePrototype.notification.notiEnum.NotiType;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.UUID;

import io.realm.annotations.PrimaryKey;

public class Notification {

    // 알림 아이디
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    // 표시될 알림의 제목
    private String title;
    // 표시될 알림 요청자 ID
    private String userId;
    // 표시될 알림 요청자 이름
    private String userName;
    // 표시될 알림 요청자 프로필 이미지 주소 url 이거나 실제 파일path
    private String profilePath = "";
    // 알림 발생 시간
    private Date updateTime;
    // 알림의 타임
    /*
    RESTORE_REQUEST 복원 요청
    RESTORE_REQUEST_SUCCESS 복원 성공
    RESTORE_REQUEST_FAILURE 복원 실패
    FRIEND_REQUEST 친구 요청
    REJECT_FRIEND_REQUEST 친구요청 거절
    MESSAGE 메세지
    EXIT 방 나감
    */
    @NotNull
    private String notiType;

    private boolean read = false;

    public Notification() {
    }

    public Notification(String id, String title, String userId, String userName, String profilePath, Date updateTime, @NotNull NotiType notiType, boolean read) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.userName = userName;
        this.profilePath = profilePath;
        this.updateTime = updateTime;
        this.notiType = notiType.toString();
        this.read = read;
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
        return NotiType.valueOf(notiType);
    }

    public void setNotiType(@NotNull NotiType notiType) {
        this.notiType = notiType.toString();
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
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
                ", read=" + read +
                '}';
    }
}
