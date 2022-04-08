package cn.guet.kitchen.entity;

public class AccessToken {
    /**
    * 小程序唯一凭证
    */
    private String appid;

    /**
    * 填写 client_credential
    */
    private String grantType;

    /**
    * 小程序唯一凭证密钥，即 AppSecret，获取方式同 appid


    */
    private String secret;

    /**
    * 获取到的凭证
    */
    private String accessToken;

    /**
    * 凭证有效时间，单位：秒。目前是7200秒之内的值。


    */
    private Integer expiresIn;

    /**
    * 失效时间
    */
    private String deadLine;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }
}