package com.zhzteam.zhz233.common.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.zhzteam.zhz233.common.config.JWTConfig;
import com.zhzteam.zhz233.model.zlb.JWTResult;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class JWTUtils {
    /**
     *
     * @Title: createJWT
     * @Description: TODO(创建token 签发JWT)
     * @param id
     * @param subject
     * @param ttlMillis
     * @return String
     * @throws
     */
    public static String createJWT(String iss, String aud, String id, String subject, long ttlMillis) {
        //指定签名的时候使用的签名算法，也就是header部分
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        ////生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //获取密钥
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setIssuer(iss)							    //发行人
                .setAudience(aud)							//观众
                .setId(id)									//jwt id
                .setSubject(subject)						//内容
                .setIssuedAt(now)							//签发时间
                .signWith(signatureAlgorithm, secretKey);	//签名
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);					//设置过期
        }
        return builder.compact();
    }

    public static JWTResult validateJWT(String jwtStr) {
        //初始化
        JWTResult jwtResult = new JWTResult();
        Claims claims = null;
        //验证
        try {
            claims = parseJWT(jwtStr);
            jwtResult.setClaims(claims);
            jwtResult.setStatus(JWTConfig.JWT_SUCCESS);//成功
        } catch (ExpiredJwtException e) {
            jwtResult.setStatus(JWTConfig.JWT_EXPIRE);//超时
        } catch (SignatureException e) {
            jwtResult.setStatus(JWTConfig.JWT_FAIL);//失败
        } catch (Exception e) {
            jwtResult.setStatus(JWTConfig.JWT_FAIL);//失败
        }
        return jwtResult;
    }
    /**
     *
     * @Title: parseJWT
     * @Description: TODO(解析JWT字符串)
     * @param jwtStr
     * @return
     * @throws Exception Claims
     * @throws
     */
    public static Claims parseJWT(String jwtStr) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwtStr)
                .getBody();
    }
    /**
     *
     * @Title: generalKey
     * @Description: TODO(由字符串生成加密key)
     * @return SecretKey
     * @throws
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(JWTConfig.JWT_SECRET);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
}
