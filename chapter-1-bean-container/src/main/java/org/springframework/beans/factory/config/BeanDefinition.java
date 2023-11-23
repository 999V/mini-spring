package org.springframework.beans.factory.config;

/**
 * bean 定义
 *
 * @author zhengxin
 * @since 1.0.0
 */
public class BeanDefinition {

    /**
     * bean 对象
     */
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
