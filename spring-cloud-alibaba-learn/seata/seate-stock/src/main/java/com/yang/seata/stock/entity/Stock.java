package com.yang.seata.stock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("STOCK")
public class Stock {

    @TableId(type = IdType.AUTO)
    @TableField("ID")
    private Long id;

    @TableField("STOCK")
    private Integer stock;
}
