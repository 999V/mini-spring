package org.spring.common.service.impl;

import cn.hutool.core.map.MapUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.common.domain.User;
import org.spring.common.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static Map<String, User> mockUserDataBase = new HashMap<>();

    static {
        mockUserDataBase.put("001", new User("001", "张三", 18));
        mockUserDataBase.put("002", new User("002", "李四", 20));
        mockUserDataBase.put("003", new User("003", "王五", 22));
        mockUserDataBase.put("004", new User("004", "赵六", 24));
    }

    @Override
    public List<User> listUser() {
        log.info("开始查询用户列表");
        if (MapUtil.isEmpty(mockUserDataBase)) {
            return null;
        }
        ArrayList<User> users = new ArrayList<>(mockUserDataBase.values());
        log.info("查询用户列表完成, 共计 {} 条数据", users.size());
        return users;
    }

}
