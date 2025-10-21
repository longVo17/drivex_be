//package com.example.drivex_be.JWT;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.agileprojectmanager.model.User;
//import org.agileprojectmanager.repository.UserRepository;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.Collections;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtTokenProvider tokenProvider;
//    private final UserRepository userRepository;
//
//    public JwtAuthenticationFilter(JwtTokenProvider tokenProvider, UserRepository userRepository) {
//        this.tokenProvider = tokenProvider;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//        throws ServletException, IOException {
//
//        String header = request.getHeader("Authorization");
//        if (header != null && header.startsWith("Bearer ")) {
//            String token = header.substring(7);
//            try {
//                String userId = tokenProvider.getUserIdFromToken(token);
//                User user = userRepository.findByUserId(userId)
//                    .orElse(null);
//
//                if (user != null) {
//                    UsernamePasswordAuthenticationToken authentication =
//                        new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            } catch (Exception e) {
//                // Token không hợp lệ => bỏ qua
//            }
//        }
//        chain.doFilter(request, response);
//    }
//}
