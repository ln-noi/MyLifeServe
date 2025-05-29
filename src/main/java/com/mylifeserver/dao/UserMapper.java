package com.mylifeserver.dao;

import com.mylifeserver.pojo.User;
import org.apache.ibatis.annotations.*;

import java.awt.print.Book;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user where account=#{account}")
    User findUserByAccount(@Param("account") String account);

    @Insert("INSERT INTO user(account, password, available, gender, name) " +
            "VALUES(#{account}, #{password}, #{available}, #{gender}, #{name})")
    int createUser(User user);

    @Select("SELECT account FROM user")
    List<String> findAllAccount();

    @Update("UPDATE user SET password=#{password} WHERE account=#{account}")
    int changePassword(@Param("account") String account, @Param("password") String password);


    @Update("UPDATE user SET image=#{path} where account=#{account}")
    int changeImage(@Param("path") String path,
                    @Param("account")String account);

    @Update("UPDATE user SET name=#{name} WHERE account=#{account}")
    int changeName(@Param("account")String account,
                   @Param("name")String name);
}
