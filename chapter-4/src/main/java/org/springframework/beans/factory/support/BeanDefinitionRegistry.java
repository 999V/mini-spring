package org.springframework.beans.factory.support;

import org.spring.common.exception.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * bean定义注册表
 *
 * @author zhengxin
 * @since 1.0.0
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册bean定义
     *
     * @param beanName       bean名字
     * @param beanDefinition bean定义
     * @throws org.spring.common.exception.BeanDefinitionStoreException bean定义异常
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionStoreException;

}
