package org.springframework.beans.factory.support;

import org.spring.common.exception.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * 抽象bean工厂
 * <p> 继承了 {@link org.springframework.beans.factory.support.DefaultSingletonBeanRegistry}，拥有了获取单例bean的能力
 * <p> 实现了 {@link org.springframework.beans.factory.BeanFactory} 接口，具备了获取bean的能力
 * <p> 定义了抽象方法 {@link #getBeanDefinition(String)}, 具备了获取 beanDefinition 的能力
 * <p> 定义了抽象方法 {@link #createBean(String, org.springframework.beans.factory.config.BeanDefinition)}, 具备了根据 beanDefinition 创建 bean 的能力，由 {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory} 子类实现
 *
 * @author zhengxin
 * @see org.springframework.beans.factory.support.DefaultSingletonBeanRegistry
 * @see org.springframework.beans.factory.BeanFactory
 * @since 1.0.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(beanDefinition, name, args);
    }


    /**
     * 获取bean定义
     *
     * @param name 名称
     * @return {@code BeanDefinition }
     * @throws BeansException Beans异常
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    /**
     * 根据 beanDefinition 创建 bean
     *
     * @param name           名称
     * @param beanDefinition bean定义
     * @return {@code Object }
     * @throws BeansException Beans异常
     */
    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;

    /**
     * 获取bean
     *
     * @param beanDefinition bean释义
     * @param beanName       bean名称
     * @param args           参数
     * @return {@code Object }
     * @throws BeansException Beans异常
     */
    protected abstract Object createBean(BeanDefinition beanDefinition, String beanName, Object[] args) throws BeansException;

}
