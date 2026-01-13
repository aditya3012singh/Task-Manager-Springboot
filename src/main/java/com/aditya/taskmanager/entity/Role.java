package com.aditya.taskmanager.entity;

import com.aditya.taskmanager.security.role.AdminRoleStrategy;
import com.aditya.taskmanager.security.role.RolePermissionStrategy;
import com.aditya.taskmanager.security.role.UserRoleStrategy;

import java.util.Set;

import static com.aditya.taskmanager.entity.Permission.*;


public enum Role {

//    level 1 we have done this
//    ROLE_USER(Set.of(Permission.TASK_CREATE, Permission.TASK_READ)),
//    ROLE_ADMIN(Set.of(Permission.TASK_CREATE, Permission.TASK_READ, Permission.TASK_UPDATE, Permission.TASK_DELETE));




//    level 2 we have done this
//    USER(Set.of(
//            TASK_CREATE,
//            TASK_READ
//    )),
//
//    ADMIN(Set.of(
//            TASK_CREATE,
//            TASK_READ,
//            TASK_UPDATE,
//            TASK_DELETE
//    ));
//
//    private final Set<Permission> permissions;
//
//    Role(Set<Permission> permissions){
//        this.permissions=permissions;
//    }
//
//    public Set<Permission> getPermissions() {
//        return permissions;
//    }


//    level final

    USER(new UserRoleStrategy()),
    ADMIN(new AdminRoleStrategy());

    private final RolePermissionStrategy strategy;

    Role(RolePermissionStrategy strategy){
        this.strategy=strategy;
    }

    public RolePermissionStrategy getStrategy() {
        return strategy;
    }
}
