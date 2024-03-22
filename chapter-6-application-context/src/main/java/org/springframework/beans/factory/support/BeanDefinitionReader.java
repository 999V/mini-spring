package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import org.spring.common.exception.BeansException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * beanDefinition 读取器
 *
 * @author zhengxin
 * @since 1.0.0
 */
public interface BeanDefinitionReader {

    /**
     * 获取 beanDefinition 注册表
     *
     *
     * @return {@code BeanDefinitionRegistry }
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     *
     * @return {@code ResourceLoader }
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载bean定义
     *
     * @param resource 资源
     * @throws cn.hutool.core.bean.BeanException bean异常
     */
    void loadBeanDefinitions(Resource resource) throws BeanException;

    /**
     * 加载bean定义
     *
     * @param resources 资源
     * @throws cn.hutool.core.bean.BeanException bean异常
     */
    void loadBeanDefinitions(Resource... resources) throws BeanException;

    /**
     * 加载bean定义
     *
     * @param location 资源位置
     * @throws cn.hutool.core.bean.BeanException bean异常
     */
    void loadBeanDefinitions(String location) throws BeanException;

    /**
     * 加载bean定义
     *
     * @param locations 位置
     * @throws BeansException Beans异常
     */
    void loadBeanDefinitions(String... locations) throws BeansException;

}
