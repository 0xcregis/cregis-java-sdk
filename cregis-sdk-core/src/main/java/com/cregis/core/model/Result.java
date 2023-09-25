package com.cregis.core.model;

import lombok.Data;

/**
 * @version 1.0.0
 * @date 2022/12/13
 */
@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public boolean isOk() {
        return "00000".equals(code);
    }
}
