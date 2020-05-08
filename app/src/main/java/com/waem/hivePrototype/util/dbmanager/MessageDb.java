package com.waem.hivePrototype.util.dbmanager;

import com.waem.hivePrototype.chatRoomList.vo.Message;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

public class MessageDb {
    private Realm realm;

    public MessageDb(Realm realm) {
        this.realm = realm;
    }

    public List<Message> getMessageList(int roomId){
        return getDb().equalTo("roomId", roomId).findAll();
    }

    public RealmQuery getDb(){
        return realm.where(Message.class);
    }

}
