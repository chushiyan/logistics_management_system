package com.chushiyan.bos.dao;

import com.chushiyan.bos.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 角色dao
 */
public interface RoleDao extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {

    // 根据name、status查询角色
    public Role findRoleByNameAndStatus(String name, Integer status);

    // 修改status值，改为0是逻辑删除，改为1是逻辑恢复
    @Query("update Role set status = ?1 where id = ?2")
    @Modifying
    public void updateStatus(Integer status, String id);


}
