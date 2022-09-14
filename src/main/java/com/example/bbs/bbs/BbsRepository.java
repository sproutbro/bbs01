package com.example.bbs.bbs;

import com.example.bbs.model.Bbs;
import com.example.bbs.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsRepository {
    int insertBbs(Bbs bbs);

    List<Bbs> selectBbsList(int pageNumber);

    int getNext();

    Bbs selectBbsByID(int bbsID);

    int updateBbs(Bbs bbs);

    int deleteBBs(int bbsID);
}
