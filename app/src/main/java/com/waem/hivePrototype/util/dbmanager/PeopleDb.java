package com.waem.hivePrototype.util.dbmanager;

import android.content.Context;
import android.util.Log;

import com.waem.hivePrototype.GlobalConst;
import com.waem.hivePrototype.chatRoomList.vo.ChatRoom;
import com.waem.hivePrototype.peopleList.vo.People;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class PeopleDb {

    private Realm realm;
    private Context context;


    public PeopleDb(Realm realm) {
        this.realm = realm;
    }

    public RealmQuery getPeopleDb(){
        return realm.where(People.class);
    }

    /*전체*/
    public List<People> getActivPeopleList(){
        return getPeopleDb()
                .equalTo("block", false)
                .equalTo("hide", false).findAll();
    }
    /*숨김*/
    public List<People> gethidePeoplelist(){
        return getPeopleDb().equalTo("hide", true).findAll();
    }
    /*차단?*/
    public List<People> getblockPeoplelist(){
        return getPeopleDb().equalTo("block", true).findAll();
    }

    public void insert(People people){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                People realmPeople = realm.createObject(People.class);

                realmPeople.setId(people.getId());
                realmPeople.setName(people.getName());
                realmPeople.setProfilePath(people.getProfilePath());
                realmPeople.setStatusMessage(people.getStatusMessage());
                realmPeople.setFavorites(people.isFavorites());
                realmPeople.setLastUpdate(people.getLastUpdate());
                realmPeople.setBlock(people.isBlock());
                realmPeople.setHide(people.isHide());

                Log.d(GlobalConst.TAG,"new save -> realm transaction 완료"+people.toString());

            }
        });
    }
    public void delete(String friendId){

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                RealmResults realmPeople = getPeopleDb().equalTo("id",friendId).findAll();

                if(friendId != null|| friendId != ""){
                    realmPeople.deleteAllFromRealm();
                    Log.d(GlobalConst.TAG,"realm 친구 데이터 삭제 완료"+realmPeople+","+friendId);
                }else{
                    Log.d(GlobalConst.TAG,"데이터 삭제 실패"+realmPeople+" , "+friendId);
                }
            }
        });

     }
     public void deleteAll(){
         final RealmResults<People> peopleList = (RealmResults<People>) getActivPeopleList();

         realm.executeTransaction(new Realm.Transaction() {
             @Override
             public void execute(Realm realm) {

                 peopleList.deleteAllFromRealm();
                 Log.d(GlobalConst.TAG,"realm 친구 데이터전체 삭제 완료");
             }
         });
     }
}
