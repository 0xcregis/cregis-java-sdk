package com.cregis.core.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0.0
 * @date 2022/12/13
 */
@Data
public class Coin {
    /**
     * 币种别名
     */
    private String name;
    /**
     * 币种全称
     */
    private String coinName;
    /**
     * 币种单位
     */
    private String symbol;
    /**
     * 币种类型
     * 0主币 1代币
     */
    private Integer type;
    /**
     * 主币类型
     */
    private String mainCoinType;
    /**
     * 代币类型
     */
    private String coinType;
    /**
     * 币种精度
     */
    private String decimals;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 币种logo
     */
    private String logo;
}
