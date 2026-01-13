package com.aditya.taskmanager.entity;

public enum Permission {
//    TASK_CREATE("task:create"),
//    TASK_READ("task:read"),
//    TASK_UPDATE("task:update"),
//    TASK_DELETE("task:delete");
//
//    private final String value;
//
//    Permission(String value){
//        this.value=value;
//    }
//
//    public String getValue() {
//        return value;
//    }

    TASK_CREATE,
    TASK_READ,
    TASK_UPDATE,
    TASK_DELETE,

    USER_READ,
    USER_MANAGE

//    fine grained
//    no business logic here

}
