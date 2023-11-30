package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略
 *
 * @author zhengxin
 * @since 1.0.0
 */
public interface InstantiationStrategy {

    /**
     * 实例化
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名称
     * @param ctor           构造函数
     * @param args           args
     * @return {@link Object}
     * @throws BeanException bean异常
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeanException;

}
