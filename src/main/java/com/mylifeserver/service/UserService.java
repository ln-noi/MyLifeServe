package com.mylifeserver.service;

import com.mylifeserver.pojo.User;

import java.nio.file.Path;
import java.util.List;

public interface UserService {
    public User findUserByAccount(String account);

    int createUser(User user);

    List<String> findAllAccount();

    int changePassword(String account, String password);

    int changeImage(String path,String account);

    int changeName(String account, String name);
}
