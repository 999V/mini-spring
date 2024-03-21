package org.spring.common.service.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.common.domain.User;
import org.spring.common.repository.UserRepository;
import org.spring.common.service.UserService;

import java.util.List;

/**
 * 用户服务实现
 *
 * @author zhengxin
 * @see UserService
 * @since 1.0.0
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    private String configName;

    private UserRepository userRepository;

    @Override
    public List<User> listUser() {
        log.info("开始查询用户列表");
        List<User> users = userRepository.list();
        log.info("查询用户列表完成, 共计 {} 条数据", users.size());
        return users;
    }

}
