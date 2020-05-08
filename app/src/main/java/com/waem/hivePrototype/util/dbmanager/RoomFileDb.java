package com.waem.hivePrototype.util.dbmanager;

import com.waem.hivePrototype.chatRoomList.vo.RoomFile;

import io.realm.Realm;
import io.realm.RealmQuery;

public class RoomFileDb {

    private Realm realm;

    public RoomFileDb(Realm realm) {
        this.realm = realm;
    }


    public RealmQuery getDb(){
        return realm.where(RoomFile.class);
    }

}
