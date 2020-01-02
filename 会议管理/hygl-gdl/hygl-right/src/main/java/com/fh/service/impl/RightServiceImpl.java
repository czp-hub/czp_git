package com.fh.service.impl;

import com.fh.dao.RightDao;
import com.fh.entity.vo.RightVo;
import com.fh.service.RightService;
import com.fh.utils.response.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightServiceImpl implements RightService {

    @Autowired
    private RightDao rightDao;

    @Override
    public ResponseServer showSystemList(Integer pId) {
        List<RightVo> rightVo = rightDao.showSystemList(pId);
        return ResponseServer.success(rightVo);
    }
}
