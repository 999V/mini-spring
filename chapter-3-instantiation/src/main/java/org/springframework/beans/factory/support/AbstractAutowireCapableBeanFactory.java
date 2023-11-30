package org.springframework.beans.factory.support;

import lombok.Data;
import org.spring.common.exception.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 抽象自动装配Bean工厂
 * <p> 继承了 {@link org.springframework.beans.factory.support.AbstractBeanFactory}，实现了 {@link #createBean(String, org.springframework.beans.factory.config.BeanDefinition)} 方法，具备了根据 beanDefinition 创建 bean 的能力
 *
 * @author zhengxin
 * @see org.springframework.beans.factory.support.AbstractBeanFactory
 * @since 1.0.0
 */
@Data
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private final InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

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

    /**
     * 根据构造器创建bean
     *
     * @param beanDefinition bean定义
     * @param beanName       bean名称
     * @param args           构造器参数
     * @return {@code Object }
     */
    @Override
    protected Object createBean(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }


    protected  Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            // 根据参数长度获取构造器
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }
}
