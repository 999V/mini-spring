package org.springframework.beans.factory;

import org.spring.common.exception.BeansException;

import java.util.Map;

/**
 * 列表能力工厂
 * <p> 继承 BeanFactory,扩展了获取 Bean 列表的能力 </p>
 *
 * @author zhengxin
 * @see BeanFactory
 * @since 1.0.0
 */
public interface ListableBeanFactory extends BeanFactory{


    /**
     * 按照类型返回 Bean 实例
     *
     * @param type 类型
     * @return {@code Map<String, T> }
     * @throws BeansException Beans异常
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


    /**
     * Return the names of all beans defined in this registry.
     *
     * @return {@code String[] }
     */
    String[] getBeanDefinitionNames();

}