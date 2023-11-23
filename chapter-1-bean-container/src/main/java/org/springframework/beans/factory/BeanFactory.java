package org.springframework.beans.factory;

import org.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean工厂
 *
 * @author zhengxin
 * @since 1.0.0
 */
public class BeanFactory {

    /**
     * Map of bean definition objects, keyed by bean name
     * <p> Bean定义对象的Map, key为bean名称
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(64);

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }


    /**
     * 注册bean定义
     *
     * @param beanName       bean名称
     * @param beanDefinition bean释义
     */
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

}
