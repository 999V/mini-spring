package org.springframework.beans.factory.support;

import org.spring.common.exception.BeanDefinitionStoreException;
import org.spring.common.exception.BeansException;
import org.spring.common.exception.NoSuchBeanDefinitionException;
import org.spring.common.util.Assert;
import org.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认的可列表化的bean工厂
 *
 * @author zhengxin
 * @see AbstractAutowireCapableBeanFactory
 * @since 1.0.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    /**
     * Map of bean definition objects, keyed by bean name
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);


    @Override
    protected BeanDefinition getBeanDefinition(String name) throws NoSuchBeanDefinitionException {
        BeanDefinition bd = this.beanDefinitionMap.get(name);
        if (bd == null) {
            throw new NoSuchBeanDefinitionException(name);
        }
        return bd;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionStoreException {
        Assert.hasText(beanName, "'beanName' must not be empty");
        Assert.notNull(beanDefinition, "BeanDefinition must not be null");
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }
    
}
