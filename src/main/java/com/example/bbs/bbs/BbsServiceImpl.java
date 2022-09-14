package com.example.bbs.bbs;

import com.example.bbs.model.Bbs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@AllArgsConstructor
public class BbsServiceImpl implements BbsService {

    private BbsRepository bbsRepository;

    @Override
    public int writeBbs(Bbs bbs) {
        bbsRepository.insertBbs(bbs);
        return bbs.getBbsID();
    }

    @Override
    public List<Bbs> getBbsList(int pageNumber) {
        pageNumber = bbsRepository.getNext() - (pageNumber - 1) * 10;
        return bbsRepository.selectBbsList(pageNumber);
    }

    @Override
    public Bbs getBbsByID(int bbsID) {
        return bbsRepository.selectBbsByID(bbsID);
    }

    @Override
    public int update(Bbs bbs) {
        return bbsRepository.updateBbs(bbs);
    }

    @Override
    public int deleteBbs(int bbsID) {
        return bbsRepository.deleteBBs(bbsID);
    }
}
