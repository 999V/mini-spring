package org.springframework.beans.factory.support;

import org.junit.Assert;
import org.junit.Test;
import org.spring.common.domain.User;
import org.spring.common.service.UserService;
import org.spring.common.service.impl.UserServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.List;

public class DefaultListableBeanFactoryTest {

    @Test
    public void test() {
        // 1.定义 BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(UserServiceImpl.class);

        // 2.定义 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 3.注册 BeanDefinition
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4.获取 Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        Assert.assertNotNull(userService);

        // 5.执行 Bean 方法
        List<User> users = userService.listUser();
        Assert.assertNotNull(users);
    }

}