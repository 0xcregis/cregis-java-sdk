package com.cregis.core.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.util.*;

/**
 * 签名工具类
 *
 * @version 1.0
 * @date 2022-11-22 15:14
 */
public class SignUtil {
    static Log log = LogFactory.get();

    /**
     * 加签
     *
     * @param map 参数map
     * @return 加签之后的值
     */
    public static String doSign(Map<String, Object> map, String apiKey) {
        Map<String, Object> newMap = new HashMap<>(map);
        log.debug("加签参数map：{}", JSONUtil.toJsonStr(newMap));
        String paramStr = paramsAsciiAsc(newMap);
        log.debug("加签参数：{}", paramStr);
        String paramStr2 = apiKey + paramStr;
        log.debug("加签参数+密钥：{}", paramStr2);
        String sign = DigestUtil.md5Hex(paramStr2).toLowerCase();
        log.debug("加签结果：{}", sign);
        return sign;
    }

    /**
     * 验签
     *
     * @param map     参数map
     * @param signStr 接收方生成的sign
     * @return boolean
     */
    public static boolean verifySign(Map<String, Object> map, String apiKey, String signStr) {
        return doSign(map, apiKey).equals(signStr);
    }

    /**
     * 对所传入的参数 进行ASCII码升序排列 最终生成字符串
     *
     * @param paramMap 参数mao
     * @return 字符串
     */
    public static String paramsAsciiAsc(Map<String, Object> paramMap) {
        Set<String> sortedParams = new TreeSet<>(paramMap.keySet());
        StringBuilder strB = new StringBuilder();
        // 排除sign和空值参数
        for (String key : sortedParams) {
            if ("sign".equalsIgnoreCase(key)) {
                continue;
            }
            Object value = paramMap.get(key);
            if (ObjectUtil.isNotNull(value) && StrUtil.isNotEmpty(value.toString())) {
                strB.append(key).append(value);
            }
        }
        return strB.toString();
    }
}

