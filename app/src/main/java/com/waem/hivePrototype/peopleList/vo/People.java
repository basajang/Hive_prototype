package com.waem.hivePrototype.peopleList.vo;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class People {

    // 사용자 ID
    @NotNull
    private String id = "";
    @NotNull
    private String name = "";
    private String profilePath = "";
    private String accessToken = null;
    private String statusMessage = "";
    private boolean favorites = false;
    private boolean Me = false;
    private Date lastUpdate;

    private boolean block = false;
    private boolean Hide = false;

    public People() {
    }

    public People(@NotNull String id, @NotNull String name, String profilePath, String accessToken, String statusMessage, boolean favorites, boolean me, Date lastUpdate, boolean block, boolean hide) {
        this.id = id;
        this.name = name;
        this.profilePath = profilePath;
        this.accessToken = accessToken;
        this.statusMessage = statusMessage;
        this.favorites = favorites;
        Me = me;
        this.lastUpdate = lastUpdate;
        this.block = block;
        Hide = hide;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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

    public boolean isMe() {
        return Me;
    }

    public void setMe(boolean me) {
        Me = me;
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
        return Hide;
    }

    public void setHide(boolean hide) {
        Hide = hide;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", profilePath='" + profilePath + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", favorites=" + favorites +
                ", Me=" + Me +
                ", lastUpdate=" + lastUpdate +
                ", block=" + block +
                ", Hide=" + Hide +
                '}';
    }
}
