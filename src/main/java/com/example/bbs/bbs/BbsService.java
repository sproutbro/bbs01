package com.example.bbs.bbs;

import com.example.bbs.model.Bbs;

import java.util.List;

public interface BbsService {
    int writeBbs(Bbs bbs);

    List<Bbs> getBbsList(int pageNumber);

    Bbs getBbsByID(int bbsID);

    int update(Bbs bbs);

    int deleteBbs(int bbsID);
}
