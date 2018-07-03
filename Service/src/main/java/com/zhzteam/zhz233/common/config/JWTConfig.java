package com.zhzteam.zhz233.common.config;

public class JWTConfig {
    /**
     * JWT密钥
     */
    public static final String JWT_SECRET  = "YmluYmluemh6MjMzMjAxOA==";//密钥binbinzhz2332018
    /**
     * JWT ISS 发行者
     */
    public static final String JWT_ISS = "ZHZTeam";
    /**
     * JWT SUB 信息
     */
    public static final String JWT_SUB = "ZHZ233_USER_AUTH0";
    /**
     * JWT 验证成功
     */
    public static final Integer JWT_SUCCESS = 0;
    /**
     * JWT 验证失败
     */
    public static final Integer JWT_FAIL = 1;
    /**
     * JWT 验证超时
     */
    public static final Integer JWT_EXPIRE = 2;
    /**
     * JWT 时间
     */
    public static final Integer JWT_TIME_30MINUTE = 30 * 60 * 1000;//30分钟
}
