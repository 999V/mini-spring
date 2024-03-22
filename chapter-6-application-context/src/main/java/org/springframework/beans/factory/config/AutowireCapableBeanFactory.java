package org.springframework.beans.factory.config;

import org.spring.common.exception.BeansException;
import org.springframework.beans.factory.BeanFactory;

/**
 * 自动装配bean工厂
 * <p>BeanFactory接口的扩展将由能够自动布线的bean工厂实现，前提是它们希望为现有bean实例公开此功能</p>
 *
 * @author zhengxin
 * @see BeanFactory
 * @since 1.0.0
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean existingBean
     * @param beanName beanName
     * @return {@code Object }
     * @throws BeansException Beans异常
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean existingBean
     * @param beanName beanName
     * @return {@code Object }
     * @throws BeansException Beans异常
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
