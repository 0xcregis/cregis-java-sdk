package com.cregis.core.client;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.cregis.core.constant.ApiPaths;
import com.cregis.core.model.*;
import com.cregis.core.util.SignUtil;

import java.util.Map;

/**
 * hutool版UdunClient
 *
 * @version 1.0.0
 * @since 2022/12/13
 */
public class HutoolCregisClient implements CregisClient {
    Log log = LogFactory.get();
    /**
     * 地址
     */
    private final String url;
    /**
     * 密钥
     */
    private final String apiKey;
    /**
     * 项目编号
     */
    private final Long pid;

    public HutoolCregisClient(String url, String apiKey, Long pid) {
        this.url = url;
        this.apiKey = apiKey;
        this.pid = pid;
    }

    @Override
    public Result<AddressLegal> addressLegal(String chainId, String address) {
        Map<String, Object> paramsMap = MapUtil.<String, Object>builder().put("pid", pid).put("chain_id", chainId).put("address", address).build();
        doSign(paramsMap);
        HttpResponse httpResponse = HttpRequest.post(url + ApiPaths.ADDRESS_LEGAL).body(JSONUtil.toJsonStr(paramsMap)).execute();
        return JSONUtil.toBean(httpResponse.body(), new TypeReference<Result<AddressLegal>>() {
        }, true);
    }

    @Override
    public Result<AddressInner> addressInner(String chainId, String address) {
        Map<String, Object> paramsMap = MapUtil.<String, Object>builder().put("pid", pid).put("chain_id", chainId).put("address", address).build();
        doSign(paramsMap);
        HttpResponse httpResponse = HttpRequest.post(url + ApiPaths.ADDRESS_INNER).body(JSONUtil.toJsonStr(paramsMap)).execute();
        return JSONUtil.toBean(httpResponse.body(), new TypeReference<Result<AddressInner>>() {
        }, true);
    }

    @Override
    public Result<Payout> payout(String address, String currency, String amount, String thirdPartyId, String callbackUrl, String remark) {
        Map<String, Object> paramsMap = MapUtil.<String, Object>builder().put("pid", pid).put("address", address).put("currency", currency).put("amount", amount).put("callback_url", callbackUrl).put("third_party_id", thirdPartyId).put("remark", remark).build();
        doSign(paramsMap);
        HttpResponse httpResponse = HttpRequest.post(url + ApiPaths.PAYOUT).body(JSONUtil.toJsonStr(paramsMap)).execute();
        return JSONUtil.toBean(httpResponse.body(), new TypeReference<Result<Payout>>() {
        }, true);
    }

    @Override
    public Result<PayoutQuery> payoutQuery(Long cid) {
        Map<String, Object> paramsMap = MapUtil.<String, Object>builder().put("pid", pid).put("cid", cid).build();
        doSign(paramsMap);
        HttpResponse httpResponse = HttpRequest.post(url + ApiPaths.PAYOUT_QUERY).body(JSONUtil.toJsonStr(paramsMap)).execute();
        return JSONUtil.toBean(httpResponse.body(), new TypeReference<Result<PayoutQuery>>() {
        }, true);
    }

    @Override
    public Result<ProjectAddress> addressCreate(String mainCoinType, String callbackUrl, String alias) {
        Map<String, Object> paramsMap = MapUtil.<String, Object>builder().put("pid", pid).put("chain_id", mainCoinType).put("callback_url", callbackUrl).put("alias", alias).build();
        doSign(paramsMap);
        HttpResponse httpResponse = HttpRequest.post(url + ApiPaths.ADDRESS_CREATE).body(JSONUtil.toJsonStr(paramsMap)).execute();
        return JSONUtil.toBean(httpResponse.body(), new TypeReference<Result<ProjectAddress>>() {
        }, true);
    }

    /**
     * 列出支持币种
     * @return 币种列表
     */
    @Override
    public Result<ProjectCoins> listCoins() {
        Map<String, Object> paramsMap = MapUtil.<String, Object>builder().put("pid", pid).build();
        doSign(paramsMap);
        HttpResponse httpResponse = HttpRequest.post(url + ApiPaths.PROJECT_COINS).body(JSONUtil.toJsonStr(paramsMap)).execute();
        return JSONUtil.toBean(httpResponse.body(), new TypeReference<Result<ProjectCoins>>() {
        }, true);
    }

    private void doSign(Map<String, Object> paramsMap) {
        paramsMap.put("timestamp", DateUtil.current());
        paramsMap.put("nonce", RandomUtil.randomString(6));
        paramsMap.put("sign", SignUtil.doSign(paramsMap, apiKey));
        log.debug("请求参数：{}", JSONUtil.toJsonStr(paramsMap));
    }
}
