package com.cregis.core.model;

import lombok.Data;

import java.util.List;

/**
 * @author kangyang
 * @classname ProjectCoins
 * @description 项目币种
 * @date 2023-08-21 11:54
 * @version 1.0
 */
@Data
public class ProjectCoins {
    private List<ProjectCoin> payout_coins;
    private List<ProjectCoin> address_coins;
    private List<ProjectCoin> order_coins;
}
