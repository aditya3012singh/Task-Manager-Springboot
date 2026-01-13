package com.aditya.taskmanager.security.role;

import com.aditya.taskmanager.entity.Permission;

import java.util.Set;

public class AdminRoleStrategy implements RolePermissionStrategy{

    @Override
    public Set<Permission> permissions(){
        return Set.of(
                Permission.TASK_CREATE,
                Permission.TASK_READ,
                Permission.TASK_UPDATE,
                Permission.TASK_DELETE,
                Permission.USER_MANAGE
        );
    }
}
