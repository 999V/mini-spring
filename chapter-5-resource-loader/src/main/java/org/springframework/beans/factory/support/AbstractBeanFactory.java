package org.springframework.beans.factory.support;

import org.spring.common.exception.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象bean工厂
 * <p> 继承了 {@link DefaultSingletonBeanRegistry}，拥有了获取单例bean的能力
 * <p> 实现了 {@link org.springframework.beans.factory.BeanFactory} 接口，具备了获取bean的能力
 * <p> 定义了抽象方法 {@link #getBeanDefinition(String)}, 具备了获取 beanDefinition 的能力
 * <p> 定义了抽象方法 {@link #createBean(String, org.springframework.beans.factory.config.BeanDefinition, Object[])},具备了根据 beanDefinition 创建 bean 的能力，由 {@link AbstractAutowireCapableBeanFactory} 子类实现
 *
 * @author zhengxin
 * @see DefaultSingletonBeanRegistry
 * @see org.springframework.beans.factory.BeanFactory
 * @since 1.0.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
