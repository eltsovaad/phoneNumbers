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
        //Creates users in a list
        User user1=new User("Ivan",1,"123456789");
        User user2=new User("Denis",2,"987654321");
        User user3=new User("Ann",1,"32145678");
        User user4=new User("Jane",2,"789654321");
        USER_LIST.add(user1);
        USER_LIST.add(user2);
        USER_LIST.add(user3);
        USER_LIST.add(user4);
    }

    @Override
    public String read(int ID,String name) {
        //returns phone number as a string if it can be found in a list
        String retValue="Not found";
        for (User i : USER_LIST) {
            if (i.getCompany().equals(ID)) {
                retValue="Can't find user with this name in a company";
                if(i.getName().equals(name))
                return i.getPhone();
            }
        }
        return retValue;
    }
}
