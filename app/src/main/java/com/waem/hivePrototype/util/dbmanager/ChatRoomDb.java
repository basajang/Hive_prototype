package com.waem.hivePrototype.util.dbmanager;

import android.util.Log;

import com.waem.hivePrototype.GlobalConst;
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

    public void insert(ChatRoom chatRoom){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                ChatRoom realmChatRoom = realm.createObject(ChatRoom.class);

                // get,set Method 생성해야함
                realmChatRoom.setRoomName(chatRoom.getRoomName());
                realmChatRoom.setRoomProfilePath(chatRoom.getRoomProfilePath());
                realmChatRoom.setFileList(chatRoom.getFileList());
                realmChatRoom.setMessageList(chatRoom.getMessageList());
                realmChatRoom.setWallpapers(chatRoom.getWallpapers());
                realmChatRoom.setFavorites(chatRoom.isFavorites());
                realmChatRoom.setDivisionMessage(chatRoom.isDivisionMessage());
                realmChatRoom.setDivisionImage(chatRoom.isDivisionImage());
                realmChatRoom.setDivisionMovie(chatRoom.isDivisionMovie());
                realmChatRoom.setDivisionFile(chatRoom.isDivisionFile());
                realmChatRoom.setSecurityStrength(chatRoom.getSecurityStrength());
                realmChatRoom.setBlindType(chatRoom.getBlindType());
                realmChatRoom.setBlindTime(chatRoom.getBlindTime());
                realmChatRoom.setNoti(chatRoom.isNoti());

                Log.d(GlobalConst.TAG, chatRoom.toString());
                Log.d(GlobalConst.TAG, "new save -> realm transaction 완료");

            }
        });


    }

}
