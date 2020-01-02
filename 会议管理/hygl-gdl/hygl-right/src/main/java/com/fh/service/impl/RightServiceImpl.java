package com.fh.service.impl;

import com.fh.dao.RightDao;
import com.fh.entity.vo.RightVo;
import com.fh.service.RightService;
import com.fh.utils.response.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RightServiceImpl implements RightService {

    @Autowired
    private RightDao rightDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResponseServer showSystemList(Integer pId) {
        Boolean rightsBoolean = redisTemplate.hasKey("rights");
        List<RightVo> rightVos = new ArrayList<RightVo>();
        if (rightsBoolean) {
            rightVos = (List<RightVo>) redisTemplate.opsForValue().get("rights");
        } else {
            rightVos = rightDao.showSystemList();
            redisTemplate.opsForValue().set("rights",rightVos);
        }
        List<RightVo> rightVoList = rightVos.stream()
                .filter(rightVo -> rightVo.getPId().equals(pId))
                .collect(Collectors.toList());
        return ResponseServer.success(rightVoList);
    }
}
