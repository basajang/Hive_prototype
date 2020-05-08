package com.waem.hivePrototype.util.dbmanager;

import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

import static io.realm.internal.SyncObjectServerFacade.getApplicationContext;

public class ChatRoomDb {

    private Realm realm;

    public ChatRoomDb(Realm realm) {
        this.realm = realm;
    }

    public RealmQuery getDb(){

        return realm.where(ChatRoom.class);
    }

    public List<ChatRoom> getChatRoomList(){

        return getDb().findAll();

    }




}
