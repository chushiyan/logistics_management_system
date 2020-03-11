package com.chushiyan.bos.filter;

import com.chushiyan.bos.shiro.JwtToken;
import com.chushiyan.bos.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 自定义过滤器，设置给shiro
 * 1. 检验是否带有Authorization请求头
 * 2. 如果带有 token，执行 shiro 的 login() 方法，将 token 提交到 Realm 中进行检验；
 *    如果没有 token，说明当前状态为游客状态（或者其他一些不需要进行认证的接口）
 */
public class JwtFilter extends BasicHttpAuthenticationFilter {

    @Autowired
    private JwtUtil jwtUtil;

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        // 调用isLoginAttempt()以判断是否带有Authorization请求头进行登录
        if (isLoginAttempt(request, response)) {
            try {
                // 如果存在，则进入 executeLogin()执行登入，检查 token 是否正确
                executeLogin(request, response);
            } catch (Exception e) {
                // 如果登陆失败，调用response401()重定向到/401
                response401(request, response);
            }
        }
        // 如果请求头不存在token，则可能是执行登陆操作或者是游客状态访问，无需检查token，直接返回 true
        return true;
    }


    /**
     * 根据是否带有Authorization请求头，判断是否是登录请求
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization");
        return authorization != null;
    }

    /**
     * 执行shiro登录
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        // 从请求头中获取token
        String authorization = httpServletRequest.getHeader("Authorization");

        // 传入token构建自定义的JwtToken
        JwtToken token = new JwtToken(authorization);

        // 提交给自定义的UserRealm进行登入，如果错误会抛出异常并被捕获
        getSubject(request, response).login(token);

        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }


    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    /**
     * illegal request forward to /401
     */
    private void response401(ServletRequest req, ServletResponse resp) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.sendRedirect("/401");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}