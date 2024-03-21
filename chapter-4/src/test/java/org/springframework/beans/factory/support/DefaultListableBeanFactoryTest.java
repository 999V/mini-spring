package org.springframework.beans.factory.support;

import org.junit.Test;
import org.spring.common.repository.UserRepository;
import org.spring.common.service.UserService;
import org.spring.common.service.impl.UserServiceImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;

public class DefaultListableBeanFactoryTest {

    @Test
    public void test() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 userRepository 定义
        beanFactory.registerBeanDefinition("userRepository", new BeanDefinition(UserRepository.class));

        // 3.注册 userService 定义
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("configName", "Apollo Config"));
        propertyValues.addPropertyValue(new PropertyValue("userRepository", new BeanReference("userRepository")));

        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserServiceImpl.class, propertyValues));

        // 4.获取 bean 实例
        UserService userService = (UserService) beanFactory.getBean("userService");

        // 5.测试 userService 的能力
        System.out.println(userService.listUser());
    }

}