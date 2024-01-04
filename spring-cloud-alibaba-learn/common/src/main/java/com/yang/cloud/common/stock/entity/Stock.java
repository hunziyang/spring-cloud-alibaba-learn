package com.yang.cloud.common.stock.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Stock {

    private Long id;
    private String name;
    private Long stock;
}
