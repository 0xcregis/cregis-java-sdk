## 接入方式

### 普通Java项目接入

1）安装

```xml
<dependency>
    <groupId>com.cregis</groupId>
    <artifactId>cregis-sdk-core</artifactId>
    <version>${latest.version}</version>
</dependency>
```

2）使用

参数对应项目`API`中的三个参数。

```java
CregisClient udunClient = new HutoolCregisClient(url, apiKey, projectId);
//地址格式校验
String address1 = "TU5ypgt9vThayzSTWNiKYzwhT7uWDgcsUm";
Result<Boolean> isLegalAddressResult1 = udunClient.addressLegal("195", address1);
```

### Springboot项目接入

1）安装

```xml
 <dependency>
    <groupId>com.cregis</groupId>
    <artifactId>cregis-sdk-spring-boot-starter</artifactId>
    <version>${latest.version}</version>
</dependency>
```

2）配置（以yml格式为例）

配置参数对应项目`API`中的三个参数。

```yaml
cregis:
  sdk:
    url: http://a0c1369e-12ec-467f-9989-7aba384a25e3.apple806.cc:81
    apiKey: f502a9ac9ca54327986f29c03b271491
    pid: 1382528827416576
```

3）使用

在`Bean`中注入`CregisClient`,就可直接使用其中的方法

```java
@Autowired
CregisClient cregisClient;

/**
 * 检测地址合法性
 */
@ApiOperation("检测地址合法性")
@GetMapping("/address-legal")
public Result<?> isLegalAddress(String mainCoinType, String address) {
    return cregisClient.addressLegal(mainCoinType, address);
}
```

## API

```java
    /**
     * 检测地址合法性
     *
     * @param chainId 链编号
     * @param address 地址
     * @return 结果
     */
    Result<AddressLegal> addressLegal(String chainId, String address);

    /**
     * 检测地址在项目中是否存在
     *
     * @param chainId 链编号
     * @param address 地址
     * @return 结果
     */
    Result<AddressInner> addressInner(String chainId, String address);

    /**
     * 获取支持的币种
     */
    Result<ProjectCoins> listCoins();

    /**
     * 发送提币申请
     *
     * @param address      提币地址
     * @param currency 币种信息，规则参考 <a href="https://app.apifox.com/link/project/2923699/apis/doc-2804947"/>
     * @param amount       金额
     * @param thirdPartyId 业务编号
     * @param callbackUrl  回调地址
     * @param remark 备注
     * @return 提币结果
     */
    Result<Payout> payout(String address, String currency, String amount, String thirdPartyId, String callbackUrl, String remark);

    /**
     * 提币申请查看
     * @param cid 业务编号
     * @return 申请详细信息
     */
    Result<PayoutQuery> payoutQuery(Long cid);

    /**
     * 生成地址
     * @param mainCoinType 主币编号
     * @param callbackUrl 回调地址
     * @param alias 地址别名
     * @return 地址信息
     */
    Result<ProjectAddress> addressCreate(String mainCoinType, String callbackUrl, String alias);
```

