package org.springframework.beans.factory;

import org.junit.Assert;
import org.junit.Test;
import org.spring.common.domain.User;
import org.spring.common.service.UserService;
import org.spring.common.service.impl.UserServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.List;


/**
 * bean工厂测试
 *
 * @author zhengxin
 * @since 1.0.0
 */
public class BeanFactoryTest {
    @Test
    public void testBeanFactory() {
        // 1.定义 BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition( new UserServiceImpl());

        // 2.定义 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 3.注册 BeanDefinition
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4.获取 Bean
        UserService userService = (UserService) beanFactory.getBean("userService");

        // 5.执行 Bean 方法
        List<User> users = userService.listUser();
        Assert.assertNotNull(users);
    }

}