package com.chushiyan.bos.dao;

import com.chushiyan.bos.pojo.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chushiyan
 * @email chushiyan0415@163.com
 * @description 权限dao
 */
public interface PrivilegeDao extends JpaRepository<Privilege, String> {
}
