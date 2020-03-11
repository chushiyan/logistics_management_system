package com.chushiyan.bos.service;

import com.chushiyan.bos.dao.RoleDao;
import com.chushiyan.bos.dao.UserDao;
import com.chushiyan.bos.entity.ResultMessage;
import com.chushiyan.bos.queryvo.UserQueryVo;
import com.chushiyan.bos.pojo.Role;
import com.chushiyan.bos.pojo.User;
import com.chushiyan.bos.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 用户service
 */

@Transactional
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // 增加用户
    public void add(UserQueryVo queryVo) {

        User user = new User();

        user.setId(String.valueOf(idWorker.nextId()));

        Set<Role> roleSet = new HashSet<Role>();
        // 如果指定了角色，就添加角色
        if (queryVo.getRoles() != null && queryVo.getRoles().length > 0) {

            for (String roleId : queryVo.getRoles()) {
                roleSet.add(roleDao.findById(String.valueOf(roleId)).orElse(null));
            }
            user.setRoles(roleSet);
        }

        user.setName(queryVo.getName());

        user.setPassword(bCryptPasswordEncoder.encode(queryVo.getPassword()));

        user.setStatus(1);

        userDao.save(user);

    }


    // 逻辑删除用户
    public void deleteById(String id) {
        userDao.updateStatus(0, id);
    }

    // 修改用户
    public void updateById(UserQueryVo queryVo) {

        Optional optional = userDao.findById(queryVo.getId());

        if (!optional.isPresent()) {
            throw new RuntimeException(ResultMessage.USER_NOT_FOUND);
        }
        User user = (User) optional.get();

        // 先清空之前的角色，再设置新的角色
        user.getRoles().clear();
        if (queryVo.getRoles() != null && queryVo.getRoles().length > 0) {
            for (String roleId : queryVo.getRoles()) {
                user.getRoles().add(roleDao.findById(roleId).orElse(null));
            }
        }
        user.setName(queryVo.getName());

        user.setPassword(bCryptPasswordEncoder.encode(queryVo.getPassword()));

        user.setStatus(queryVo.getStatus());

        userDao.save(user);

    }

    // 根据id查询用户
    public User findById(String id) {
        Optional optional = userDao.findById(id);
        if(!optional.isPresent()){
            throw new RuntimeException(ResultMessage.USER_NOT_FOUND);
        }
        return (User) optional.get();
    }


    // 分页查询
    public Page<User> paging(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("name").descending());
        return userDao.findAll(pageable);
    }


    // 登录
    public User login(UserQueryVo userQueryVo) {

        User userFromDB = userDao.findUserByNameAndStatus(userQueryVo.getName(), 1);

        if (userFromDB != null && bCryptPasswordEncoder.matches(userQueryVo.getPassword(), userFromDB.getPassword())) {
            return userFromDB;
        }else{
            throw new RuntimeException(ResultMessage.USER_NOT_FOUND);
        }

    }
}
