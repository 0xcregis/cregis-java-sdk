package com.cregis.core;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.cregis.core.client.CregisClient;
import com.cregis.core.client.HutoolCregisClient;
import com.cregis.core.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author miller
 * @version 1.0.0
 * @date 2022/12/15
 */
public class HutoolClientTest {
    CregisClient cregisClient;

    @BeforeEach
    void init() {
        String url = "http://xxx.com";
        String apiKey = "fe37337a19e847e9b02ed064ef2afe96";
        Long projectId = 1387710834180096L;
        cregisClient = new HutoolCregisClient(url, apiKey, projectId);
    }

    /**
     *  创建地址
     */
    @Test
    void addressCreate() {
        Result<ProjectAddress> result = cregisClient.addressCreate("195", "", "");
        if (result.isOk()) {
            Console.log(result.getData());
        }
    }

    /**
     * 地址格式校验
     */
    @Test
    void addressLegal() {
        Result<AddressLegal> result = cregisClient.addressLegal("195", "TU5ypgt9vThayzSTWNiKYzwhT7uWDgcsUm");
        if (result.isOk()) {
            Console.log(result.getData());
        }
    }

    /**
     * 是否项目地址
     */
    @Test
    void addressInner() {
        Result<AddressInner> result = cregisClient.addressInner("195", "TU5ypgt9vThayzSTWNiKYzwhT7uWDgcsUm");
        if (result.isOk()) {
            Console.log(result.getData());
        }
    }

    /**
     * 项目地址列表
     */
    @Test
    void listCoins() {
        Result<ProjectCoins> result = cregisClient.listCoins();
        if (result.isOk()) {
            Console.log(result.getData());
        }
    }

    /**
     * 提币
     */
    @Test
    void test() {
        Result<Payout> result = cregisClient.payout("TTxwyZqB3zqVrJc93LDeryuuteXixprqUs", "195@195", "1.1", IdUtil.nanoId(), "", "payout");
        if (result.isOk()) {
            Console.log(result.getData());
        }
    }

    /**
     * 查看提币订单
     */
    @Test
    void test01() {
        Result<PayoutQuery> result = cregisClient.payoutQuery(1389040944504832L);
        if (result.isOk()) {
            Console.log(result.getData());
        }
    }
}
