package com.cregis.core.model;

import lombok.Data;

/**
 * @author miller
 * @version 1.0.0
 * @since 2023/8/3
 */
@Data
public class AddressDepositCallback {
    /**
     * 项目编号
     */
    private Long pid;
    /**
     * 订单号
     */
    private Long cid;
    /**
     * 链编号
     */
    private String chain_id;
    /**
     * 代币编号
     */
    private String token_id;
    /**
     * 币种标识
     */
    private String currency;
    /**
     * 金额
     */
    private String amount;
    /**
     * 地址
     */
    private String address;
    /**
     * 状态
     */
    private Integer status;
    /**
     * memo
     */
    private Integer memo;
    /**
     * 交易哈希
     */
    private String txid;
    /**
     * 区块高度
     */
    private String block_height;
    /**
     * 区块时间
     */
    private Long block_time;
    /**
     * 6位随机字符串
     */
    private String nonce;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * 签名
     */
    private String sign;
}
