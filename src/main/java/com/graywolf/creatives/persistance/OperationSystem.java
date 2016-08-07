package com.graywolf.creatives.persistance;

/**
 * Created by graywolf on 7/30/16.
 */
enum OperationSystem {

    ANDROID(1, "android"),
    IOS(2, "ios");

    int id;
    String name;

    OperationSystem(int id, String name){
        this.id = id;
        this.name = name;
    }


}
