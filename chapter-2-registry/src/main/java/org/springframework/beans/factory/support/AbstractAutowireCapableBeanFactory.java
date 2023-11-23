package org.springframework.beans.factory.support;

import org.spring.common.exception.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象自动装配Bean工厂
 * <p> 继承了 {@link AbstractBeanFactory}，实现了 {@link #createBean(String, BeanDefinition)} 方法，具备了根据 beanDefinition 创建 bean 的能力
 *
 * @author zhengxin
 * @see AbstractBeanFactory
 * @since 1.0.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;

        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 注册单例
        addSingleton(name, bean);

        return bean;
    }
}
