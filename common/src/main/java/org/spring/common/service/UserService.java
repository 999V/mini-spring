package org.spring.common.service;

import org.spring.common.domain.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author zhengxin
 * @since 1.0.0
 */
public interface UserService {

    /**
     * 获取用户列表
     *
     * @return {@code List<User> }
     */
    List<User> listUser();
}
