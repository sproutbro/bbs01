package com.example.bbs.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Bbs {
    private int bbsID;
    private String bbsTitle;
    private String userID;
    private Timestamp bbsDate;
    private String bbsContent;
    private int bbsAvailable;
}
