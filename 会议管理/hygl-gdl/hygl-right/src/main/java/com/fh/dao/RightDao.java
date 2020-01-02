package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.entity.po.RightPo;
import com.fh.entity.vo.RightVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RightDao extends BaseMapper<RightPo> {

    /**
     * 初始化权限菜单
     * @return
     */
    List<RightVo> showSystemList();
}
