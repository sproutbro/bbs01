package com.example.bbs.model;

import lombok.Data;

@Data
public class User {
    private String userID;
    private String userPassword;
    private String userName;
    private String userGender;
    private String userEmail;
}
