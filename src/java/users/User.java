/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import clinic.PermissionEnum;

/**
 *
 * @author huser
 */
public abstract class User {
    private String password;
    private String name;
    private PermissionEnum permission;

    User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionEnum getPermission() {
        return permission;
    }

    public void setPermission(PermissionEnum permission) {
        this.permission = permission;
    }
    
    
    
    public void createReport(){};

    @Override
    public String toString() {
        return "password:" + password + ", name:" + name + ", permission:" + permission ;
    }
    
    
    
}
