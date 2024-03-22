package org.springframework.beans.factory.support;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.spring.common.service.UserService;
import org.spring.common.util.Assert;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanDefinitionReaderTest {

    @Test
    public void test_xml() {
        // 获取上下文
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        // 获取Bean
        UserService userService = applicationContext.getBean("userService", UserService.class);

        // 测试
        Assert.notNull(userService, "userService is null");
        System.out.println(JSON.toJSONString(userService));

        System.out.println(userService.listUser());
    }
}