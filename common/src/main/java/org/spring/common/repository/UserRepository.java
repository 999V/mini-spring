package org.spring.common.repository;

import org.spring.common.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户储存库
 *
 * @author zhengxin
 * @since 1.0.0
 */
public class UserRepository {

    private static Map<String, User> mockUserDataBase = new HashMap<>();

    static {
        mockUserDataBase.put("001", new User("001", "张三", 18));
        mockUserDataBase.put("002", new User("002", "李四", 20));
        mockUserDataBase.put("003", new User("003", "王五", 22));
        mockUserDataBase.put("004", new User("004", "赵六", 24));
    }

    public User get(String uId) {
        return mockUserDataBase.get(uId);
    }

    public List<User> list() {
        return new ArrayList<>(mockUserDataBase.values());
    }

}
