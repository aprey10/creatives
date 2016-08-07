package com.graywolf.creatives.persistance;

import lombok.Getter;

/**
 * Created by graywolf on 7/30/16.
 */
public enum OperationSystem {

    ANDROID(1, "android"),
    IOS(2, "ios"),
    WINDOWS(3, "windows"),
    LINUX(4, "linux"),
    OSX(5, "osx"),
    BLACKBERRY(6, "blackberry"),
    SYMBIAN(7, "symbian");

    @Getter
    private int id;
    private String name;

    OperationSystem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static OperationSystem findByName(String name) {
        for (OperationSystem os : values()) {
            if (os.name.equals(name)) {
                return os;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
