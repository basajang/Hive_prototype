package com.waem.hivePrototype.util.dbmanager;

import com.waem.hivePrototype.peopleList.vo.People;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

public class PeopleDb {

    private Realm realm;

    public PeopleDb(Realm realm) {
        this.realm = realm;
    }

    public RealmQuery getPeopleDb(){
        return realm.where(People.class);
    }

    public List<People> getActivPeopleList(){
        return getPeopleDb()
                .equalTo("block", false)
                .equalTo("hide", false).findAll();
    }

    public List<People> gethidePeoplelist(){
        return getPeopleDb().equalTo("hide", true).findAll();
    }

    public List<People> getblockPeoplelist(){
        return getPeopleDb().equalTo("block", true).findAll();
    }

}
