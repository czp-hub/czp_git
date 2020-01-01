package com.fh.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_pro")
public class RightPo {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String rightName;
    @TableField("pId")
    private Integer pId;
    @TableField("isShow")
    private Integer isShow;
    @TableField("relevanceRight")
    private Integer relevanceRight;

}
