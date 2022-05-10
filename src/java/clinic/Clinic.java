/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.util.*;
import users.*;

/**
 *
 * @author huser
 */
public class Clinic {
    private Map<String,User> users;
    private static Clinic clinic;
    private Clinic(){
        users=new HashMap<>();
        addUser( "y123","Yosef", PermissionEnum.PATIENT);
        addUser( "d123","David", PermissionEnum.PATIENT);
        addUser( "r123","Ruvi", PermissionEnum.PATIENT);
        addUser( "tamar","tamar", PermissionEnum.DOCTOR);

    }
    
    public static Clinic getClinic(){
        if(clinic==null){
            clinic=new Clinic();
        }
        return clinic;
    }
    
    public User addUser(String password, String name, PermissionEnum permission){
        User u= UserFactory.getNewUser(permission);
        u.setName(name);
        u.setPassword(password);
        u.setPermission(permission);
        users.put(password,u);
        return u;
    }
    
    public User getUser(String name, String password){
        if(users!=null&&users.get(password)!=null&&users.get(password).getName().equals(name))return users.get(password);
        return null;
    }
    
    
    
}
