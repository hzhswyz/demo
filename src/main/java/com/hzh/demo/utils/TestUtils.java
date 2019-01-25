package com.hzh.demo.utils;

import com.hzh.demo.model.User;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestUtils {

    @PreAuthorize("(hasRole('ROLE_user') and #message.length() <= 10) or hasRole('ROLE_admin')")
    public void doing(String message){
        System.out.println("doing...");
    }

    @PreAuthorize("hasAnyRole('ROLE_user','ROLE_admin')")
    @PostFilter("hasAnyRole('ROLE_admin')||filterObject.name==principal.username")
    public List<User> getUserList(){
        User user = new User();
        user.setName("hzh");
        User user1 = new User();
        user1.setName("admin");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        return list;
    }

    @PreAuthorize("hasAnyRole('ROLE_user','ROLE_admin')")
    //@PreFilter("hasAnyRole('ROLE_admin')||filterObject.name==principal.username")
    @PreFilter("hasPermission(filterObject,'delete')")
    public List<User> deleteUserList(List<User> list){
        return list;
    }

}
