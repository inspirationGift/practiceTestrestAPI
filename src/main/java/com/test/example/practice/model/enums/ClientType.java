package com.test.example.practice.model.enums;

public enum ClientType {
    INTERNAL(1), EXTERNAL(2);

    int type;

    ClientType(int type) {
        this.type = type;
    }

    public static ClientType getType(int typeId) {
        if (typeId == 1) return INTERNAL;
        return EXTERNAL;
    }
}
