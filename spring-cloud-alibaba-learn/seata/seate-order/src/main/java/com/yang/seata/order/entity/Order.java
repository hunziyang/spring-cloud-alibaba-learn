package com.yang.seata.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@TableName("ORDER")
@Accessors(chain = true)
@Data
public class Order {

    @TableId(type = IdType.AUTO)
    @TableField("ID")
    private Long id;

    @TableField("PRICE")
    private Integer price;
}
