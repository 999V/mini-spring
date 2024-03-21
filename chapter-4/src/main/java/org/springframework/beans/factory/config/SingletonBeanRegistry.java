package org.springframework.beans.factory.config;

/**
 * 单例bean注册表
 * <p> 该接口为共享bean实例定义注册表。可以由org.springframework.beans.factory.BeanFactory实现来实现，以便以统一的方式公开其单例管理功能。
 * ConfigurationBeanFactory接口扩展了此接口。
 *
 * @author zhengxin
 * @since 1.0.0
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例bean
     *
     * @param beanName bean名称
     * @return {@code Object }
     */
    Object getSingleton(String beanName);

}
