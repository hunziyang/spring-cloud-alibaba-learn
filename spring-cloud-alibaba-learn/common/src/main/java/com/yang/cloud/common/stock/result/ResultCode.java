package com.yang.cloud.common.stock.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode implements ResultCodeBase {

    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    VALID_ERROR(505, "Method Argument Not Valid"),
    FLOW_ERROR(1001,"Flow Err"),
    DEGRADE_ERROR(1002,"Degrade Err"),
    BLOCK_ERROR(1003,"Block Err");


    private Integer code;
    private String msg;
}
