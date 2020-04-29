package com.waem.hivePrototype.peopleList.vo;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import io.realm.RealmObject;

public class People extends RealmObject {

    // 사용자 ID
    @NotNull
    /*사용자 아이디*/
    private String id = "";
    @NotNull
    private String name = "";
    // 프로필 이미지 주소
    private String profilePath = "";

    // 상태메세지
    private String statusMessage = "";
    // 즐겨찾기 여부
    private boolean favorites = false;
    // 마지막 로그인
    private Date lastUpdate;

    // 차단 사용자
    private boolean block = false;
    // 숨김 사용자
    private boolean hide = false;

    public People() {

    }

    public People(@NotNull String id, @NotNull String name, String profilePath, String statusMessage, boolean favorites, Date lastUpdate, boolean block, boolean hide) {
        this.id = id;
        this.name = name;
        this.profilePath = profilePath;
        this.statusMessage = statusMessage;
        this.favorites = favorites;
        this.lastUpdate = lastUpdate;
        this.block = block;
        this.hide = hide;
    }

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public boolean isFavorites() {
        return favorites;
    }

    public void setFavorites(boolean favorites) {
        this.favorites = favorites;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }
}
