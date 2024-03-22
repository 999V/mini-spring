package org.springframework.beans.factory.config;

import org.spring.common.exception.BeansException;

/**
 * BeanPostProcessor
 * <p> 工厂挂钩，允许自定义修改新的bean实例，例如检查标记接口或用代理包装它们。用于修改新实例化 豆对象的扩展点
 *
 * @author zhengxin
 * @since 1.0.0
 */
public interface BeanPostProcessor {


    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean     bean
     * @param beanName bean名称
     * @return {@code Object }
     * @throws BeansException Beans异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean     bean
     * @param beanName bean名称
     * @return {@code Object }
     * @throws BeansException Beans异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;


}
