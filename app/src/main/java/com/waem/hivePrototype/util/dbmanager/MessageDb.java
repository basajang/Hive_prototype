package com.waem.hivePrototype.util.dbmanager;

import android.util.Log;

import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.chatRoomList.vo.Message;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.annotations.PrimaryKey;

public class MessageDb {
    private Realm realm;

    public MessageDb(Realm realm) {
        this.realm = realm;
    }

    /*public List<Message> getMessageList(String roomId){
        return getDb().equalTo("roomId", roomId).findAll();
    }*/

    public List<Message> getMessageList(){
        return getDb().findAll();
    }

    public RealmQuery getDb(){
        return realm.where(Message.class);
    }


    public void userInsert(Message message){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                Message realmMessage = realm.createObject(Message.class, RealmManager.getInstance().getMessage().autoIncrement());



                /*realmMessage.setMessageId(message.getMessageId());*/
                realmMessage.setRoomId(message.getRoomId());
                realmMessage.setSenderId(message.getSenderId());
                realmMessage.setMessageType(message.isMessageType());
                realmMessage.setFileType(message.getFileType());
                realmMessage.setFilepath(message.getFilepath());
                realmMessage.setSenderTime(message.getSenderTime());
                realmMessage.setText(message.getText());
                realmMessage.setRead(message.isRead());
                realmMessage.setDelete(message.isDelete());
                realmMessage.setItemViewType(message.getItemViewType());

                Log.d(GlobalConst.TAG,"new save -> realm transaction 완료"+message.toString());
            }
        });
    }

    public int autoIncrement(){
        // Get the current max id in the users table
        Number maxId = getDb().max("messageId");
        // If there are no rows, currentId is null, so the next id must be 1
        // If currentId is not null, increment it by 1
        int nextId = (maxId == null) ? 1 : maxId.intValue() + 1;
        // User object created with the new Primary key
        /*Message realmMessage = realm.createObject(Message.class, nextId);*/
        return nextId;
    }
    public void myInsert(){


    }

}
