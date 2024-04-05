package com.voluntra.backend.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.voluntra.backend.security.AdminDetailsServiceImpl;
import com.voluntra.backend.security.OrganizationDetailsServiceImpl;
import com.voluntra.backend.security.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthTokenFilter extends OncePerRequestFilter{

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AdminDetailsServiceImpl adminDetailsService;

    @Autowired
    private OrganizationDetailsServiceImpl organizationDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // try {
        //     String jwt = parseJwtFromHeader(request);
        //     if (jwt!=null && jwtUtils.validateToken(jwt)) {
        //         String username = jwtUtils.getUsernameFromToken(jwt);
        //         UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        //         UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        //         authenticationToken.setDetails(new WebAuthenticationDetails(request));
        //         SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //     }
        // } catch (Exception e) {
        //     System.err.println(e);
        // }
        // filterChain.doFilter(request, response);

        try {
            String jwt = parseJwtFromHeader(request);
            if (jwt != null && jwtUtils.validateToken(jwt)) {
                String username = jwtUtils.getUsernameFromToken(jwt);
                UserDetails userDetails = null;
    
                if (request.getRequestURI().startsWith("/auth/admin")) {
                    userDetails = adminDetailsService.loadUserByUsername(username);
                } else if (request.getRequestURI().startsWith("/auth/org")) {
                    userDetails = organizationDetailsService.loadUserByUsername(username);
                } else {
                    userDetails = userDetailsService.loadUserByUsername(username);
                }
    
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        filterChain.doFilter(request, response);
        
    }

    private String parseJwtFromHeader(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        } else {
            return null;
        }
    }
    
}