package com.example.bbs.bbs;

import com.example.bbs.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    String getUserPassword(String userID);

    int insertUser(User user);
}
