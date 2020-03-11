package com.chushiyan.bos;

import com.chushiyan.bos.utils.IdWorker;
import com.chushiyan.bos.utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
@SpringBootApplication
public class BosApplication {

    public static void main(String[] args) {
        SpringApplication.run(BosApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }


}
