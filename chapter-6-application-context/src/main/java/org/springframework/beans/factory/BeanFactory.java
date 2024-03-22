package org.springframework.beans.factory;

import org.spring.common.exception.BeansException;

/**
 * bean工厂
 * <p> 定义了 getBean 方法，提供了获取 Bean 的能力 </p>
 *
 * @author zhengxin
 * @since 1.0.0
 */
public interface BeanFactory {

    /**
     * 获取bean
     *
     * @param name 名称
     * @return {@code Object }
     * @throws org.spring.common.exception.BeansException Beans异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取bean
     *
     * @param name 名称
     * @param args 参数
     * @return {@code Object }
     * @throws org.spring.common.exception.BeansException Beans异常
     */
    Object getBean(String name, Object... args) throws BeansException;


    /**
     * 获取bean
     *
     * @param name         名称
     * @param requiredType 必需类型
     * @return {@code T }
     * @throws BeansException Beans异常
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
