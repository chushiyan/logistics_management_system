package com.chushiyan.bos.dao;

import com.chushiyan.bos.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 用户dao
 */
@Component
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    @Query("update User set status = ?1 where id = ?2")
    @Modifying
    public void updateStatus(Integer status, String id);

    // 根据用户名、status为1查询用户
    public User findUserByNameAndStatus(String name, Integer status);


}
