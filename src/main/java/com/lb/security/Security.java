package com.lb.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Security {

	private static final String SECRET_KEY = "Q1@3$d#h&m*40*&";

	/**
	 * 一个JWT实际上就是一个字符串，它由三部分组成，头部(Header)、载荷(Payload)与签名(Signature)
	 * @param id 当前用户ID
	 * @param issuer 该JWT的签发者，可选
	 * @param subject 该JWT所面向的用户,可选
	 * @param expireMillis 什么时候过期，可选
	 * @param audience 接收该JWT的一方，可选
	 * 
	 */
	public static String createJWT(String id, 
			String issuer, 
			String subject,
			Long expireMillis, 
			String audience) {
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		long millis = System.currentTimeMillis();
		
		Date now = new Date(millis);
		
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(subject).setIssuedAt(now).setIssuer(issuer)
				.setAudience(audience).signWith(signatureAlgorithm, signingKey);

		if (expireMillis >= 0) {
			long expMillis = millis + expireMillis;
			Date exp = new Date(expMillis);
			jwtBuilder.setExpiration(exp);
		}
		
		return jwtBuilder.compact();
		
	}

	/**
	 * 私钥解密token信息
	 * @param jwt
	 * @return
	 */
	public static Claims getClaims(String jwt) {
		return Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.parseClaimsJws(jwt)
				.getBody();
	}

	public static void main(String[] args) {
		String userId = "WKSH121321KKsdfk";
		String issuer = "www.cx.com";
		String subject = "周日被我射熄火了，所以今天是周一。";
		long ttlMillis = 1000 * 60;
		String audience = "school";
		String token = Security.createJWT(userId, issuer, subject, ttlMillis, audience);
		// 打印出token信息
		System.out.println(token);
		// 解密token信息
		Claims claims = Security.getClaims(token);
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());
	}
}
