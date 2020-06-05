package com.phonenumbers.service;

import com.phonenumbers.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final List<User> USER_LIST = new ArrayList<>();

    @Override
    public void create(){
        User user1=new User("Ivan",1,"123456789");
        User user2=new User("Denis",2,"987654321");
        USER_LIST.add(user1);
        USER_LIST.add(user2);
    }

    @Override
    public User read(int ID,String name) {
        User retValue=null;
        for (User i : USER_LIST) {
            if (i.getCompany().equals(ID)) {
                if(i.getName().equals(name))
                retValue=i;
            }
        }
        return retValue;
    }
}
