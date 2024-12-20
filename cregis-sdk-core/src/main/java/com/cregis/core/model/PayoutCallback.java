package com.cregis.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author miller
 * @version 1.0.0
 * @since 2023/7/3
 */
@NoArgsConstructor
@Data
public class PayoutCallback {
    /**
     * 项目编号
     */
    private Long pid;

    /**
     * 订单号
     */
    private Long cid;
    /**
     * 地址
     */
    private String address;
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
     * 调用方业务编号
     */
    private String third_party_id;
    /**
     * 备注
     */
    private String remark;
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
