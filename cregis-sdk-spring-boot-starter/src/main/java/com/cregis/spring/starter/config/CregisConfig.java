package com.cregis.spring.starter.config;

import com.cregis.core.client.HutoolCregisClient;
import com.cregis.core.client.CregisClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author miller
 * @version 1.0.0
 * @since 2022/12/15
 */
@EnableConfigurationProperties(CregisProps.class)
public class CregisConfig {
    @Bean
    CregisProps cregisProps() {
        return new CregisProps();
    }
    @Bean
    public CregisClient cregisClient(CregisProps cregisProps) {
        return new HutoolCregisClient(cregisProps.getUrl(), cregisProps.getApiKey(), cregisProps.getPid());
    }
}
