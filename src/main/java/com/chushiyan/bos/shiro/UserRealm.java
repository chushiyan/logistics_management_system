package com.chushiyan.bos.shiro;

import com.chushiyan.bos.dao.RoleDao;
import com.chushiyan.bos.dao.UserDao;
import com.chushiyan.bos.pojo.Privilege;
import com.chushiyan.bos.pojo.Role;
import com.chushiyan.bos.pojo.User;
import com.chushiyan.bos.service.UserService;
import com.chushiyan.bos.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.logging.log4j.LogManager;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        Claims claims = jwtUtil.parseJWT(principals.toString());
        String name = claims.getSubject();

        User user = userDao.findUserByNameAndStatus(name, 1);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addRole(user.getRole());

        ArrayList<String> privilegePathList = new ArrayList<String>();

        // 查询该用户所有的权限
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                if (role != null) {
                    if ("系统管理员".equals(role.getName())) {
                        for (Privilege privilege : role.getPrivileges()) {
                            for (Privilege son : privilege.getChildren()) {
                                for (Privilege grandson : son.getChildren()) {
                                    privilegePathList.add(grandson.getPath());
                                }
                            }
                        }
                    } else {
                        for (Privilege privilege : role.getPrivileges()) {
                            for (Privilege son : privilege.getChildren()) {
                                privilegePathList.add(son.getPath());
                            }
                        }
                    }
                }
            }
        }
        simpleAuthorizationInfo.addStringPermissions(privilegePathList);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();

        Claims claims = null;
        String name = null;

        try {
            claims = jwtUtil.parseJWT(token);
            name = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("token invalid");
        }

        User user = userDao.findUserByNameAndStatus(name, 1);

        if (user == null) {
            throw new RuntimeException("User didn't existed!");
        }

        return new SimpleAuthenticationInfo(token, token, this.getName());
    }

}
