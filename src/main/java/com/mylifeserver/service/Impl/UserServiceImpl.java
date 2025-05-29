package com.mylifeserver.service.Impl;

import com.mylifeserver.dao.UserMapper;
import com.mylifeserver.pojo.User;
import com.mylifeserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User findUserByAccount(String account){
        User user = userMapper.findUserByAccount(account);
        return user;
    }

    @Override
    public int createUser(User user) {
        int flag=userMapper.createUser(user);
        return flag;
    }

    @Override
    public List<String> findAllAccount() {
        userMapper.findAllAccount();
        return userMapper.findAllAccount();
    }

    @Override
    public int changePassword(String account, String password) {
        int flag=userMapper.changePassword(account,password);
        return flag;
    }

    @Override
    public int changeImage(String path,String account) {
        return userMapper.changeImage(path,account);
    }

    @Override
    public int changeName(String account, String name) {
        int flag=userMapper.changeName(account,name);
        return flag;
    }
}
