package org.springframework.beans.factory.support;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.spring.common.exception.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization 执行， beanName{}, bean:{}", beanName, JSON.toJSONString(bean));
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInitialization 执行， beanName{}, bean:{}", beanName, JSON.toJSONString(bean));
        return bean;
    }

}
