package org.springframework.beans.factory;

import org.spring.common.exception.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 可配置 bean工厂
 *
 * @author zhengxin
 * @see ListableBeanFactory
 * @see AutowireCapableBeanFactory
 * @see ConfigurableBeanFactory
 * @since 1.0.0
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 获取bean释义
     *
     * @param beanName bean名称
     * @return {@code BeanDefinition }
     * @throws BeansException Beans异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 预实例化单例
     *
     * @throws BeansException Beans异常
     */
    void preInstantiateSingletons() throws BeansException;
}
