package com.waem.hivePrototype.util.dbmanager;


import com.waem.hivePrototype.ConfigureManager;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.chatRoomList.vo.Message;
import com.waem.hivePrototype.chatRoomList.vo.RoomFile;
import com.waem.hivePrototype.peopleList.vo.People;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

import static io.realm.internal.SyncObjectServerFacade.getApplicationContext;

public class RealmManager {

    private static RealmManager instance = new RealmManager();

    private Realm realm;

    public RealmManager() {

    }

    public static RealmManager getInstance() {

        if (null == instance) {
            instance = new RealmManager();
        }

        return instance;
    }

    public void build(){

        Realm.init(ConfigureManager.getInstance().getActivity().getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    /**
     * 렐름 디비 마이그레이션을 작업 할 메서드
     */
    public void realmConfiguration(){

    }

    public Realm getRealm() {

       /* if(null != realm){
            build();
        }*/
        build();
        return realm;
    }

    public PeopleDb getPeople(){
        return new PeopleDb(getRealm());
    }

    public ChatRoomDb getChatRoom(){
        return new ChatRoomDb(getRealm());
    }

    public MessageDb getMessage(){
        return new MessageDb(getRealm());
    }

    public RoomFileDb getRoomFile(){
        return new RoomFileDb(getRealm());
    }

    public UserTestDb getUserTest(){
        return new UserTestDb(getRealm());
    }





}
