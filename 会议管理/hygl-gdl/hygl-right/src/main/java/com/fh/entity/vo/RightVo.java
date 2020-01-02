package com.fh.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RightVo implements Serializable {

    private Integer id;
    private String rightName;
    private Integer pId;
    private Integer relevanceRight;

}
