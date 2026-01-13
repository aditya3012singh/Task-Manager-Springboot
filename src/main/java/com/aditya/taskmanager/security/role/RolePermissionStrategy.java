package com.aditya.taskmanager.security.role;

import com.aditya.taskmanager.entity.Permission;

import java.util.Set;

public interface RolePermissionStrategy {
    Set<Permission> permissions();
//    This is the Strategy Pattern.
}
