//package com.example.drivex_be.JWT;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.agileprojectmanager.model.User;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
////    @Value("${jwt.secret}")
////    private String jwtSecret;
////
////    @Value("${jwt.expiration}")
////    private long jwtExpirationInMs;
//
//    private final String SECRET_KEY = "KjYMmc9GFyw7BKwUB0fCUD0FLiOtFXoALlGSytvcyc4=";
//
//    public String generateToken(User user) {
//        // 1 ngày
//        long EXPIRATION_MS = 86400000;
//        return Jwts.builder()
//            .setSubject(String.valueOf(user.getUserId())) //Lưu ID người dùng trong subject
//            .claim("fullName", user.getFullName())
//            .claim("email", user.getEmail())
//            .claim("jiraUserId", user.getUserId())
//            .setIssuedAt(new Date())
//            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
//            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//            .compact();
//    }
//
//    public String getUserIdFromToken(String token) {
//       Claims claims = Jwts.parser()
//            .setSigningKey(SECRET_KEY)
//            .parseClaimsJws(token)
//            .getBody();
//        return  claims.getSubject(); // Trả về ID người dùng từ subject
//    }
//
//    // Kiểm tra token có hợp lệ không (tùy chọn)
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
