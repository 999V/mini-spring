package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 共享bean实例的通用注册表，实现SingletonBeanRegistry。允许注册应该为注册表的所有调用方共享的单例实例，这些实例将通过bean名称获得。
 *
 * @author zhengxin
 * @see SingletonBeanRegistry
 * @since 1.0.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /** Cache of singleton objects: bean name --> bean instance */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);

    @Override
    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }

    /**
     * 将给定的singleton对象添加到此工厂的singleton缓存中
     *
     * @param beanName        bean名称
     * @param singletonObject singleton对象
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        synchronized (this.singletonObjects) {
            this.singletonObjects.put(beanName, singletonObject);
        }
    }
}
