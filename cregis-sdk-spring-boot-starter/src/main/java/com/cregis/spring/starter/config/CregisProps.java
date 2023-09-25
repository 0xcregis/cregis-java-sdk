package com.cregis.spring.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author miller
 * @version 1.0.0
 * @since 2022/12/15
 */
@ConfigurationProperties(prefix = "cregis.sdk")
@Data
public class CregisProps {
    /**
     * 地址
     */
    private String url;
    /**
     * 密钥
     */
    private String apiKey;
    /**
     * 项目编号
     */
    private Long pid;
}
