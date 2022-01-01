package com.example.demo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static int userCount = 5;
    private static List<User> userList = new ArrayList<>();

    //static block
    static {
//adding users to the list
        userList.add(new User(1, "John", new Date()));
        userList.add(new User(2, "Robert", new Date()));
        userList.add(new User(3, "Adam", new Date()));

        userList.add(new User(4, "Andrew", new Date()));
        userList.add(new User(5, "Jack", new Date()));
    }

    //method that retrieve all users from the list
    public List<User> findAll() {
        return userList;
    }

    //method that add the user in the list
    public User save(User user) {
        if (user.getId() > 0) {
//increments the user id
            user.setId(++userCount);
        }
        userList.add(user);
        return user;
    }

    //method that find a particular user from the list
    public User findOne(int id) {
        for (User user : userList) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
