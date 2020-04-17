package com.waem.hivePrototype.chatRoomList.vo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

    @NotNull
    private String roomId;
    @NotNull
    private String roomName;
    private List<String> roomProfilePath = new ArrayList<>();

    @NotNull
    private String wallpapers = "";
    private boolean favorites = false;



}
