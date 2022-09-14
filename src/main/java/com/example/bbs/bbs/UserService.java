package com.example.bbs.bbs;

import com.example.bbs.model.User;

public interface UserService {
    int login(String userID, String userPassword);

    int join(User user);
}
