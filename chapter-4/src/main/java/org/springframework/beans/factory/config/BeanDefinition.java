package org.springframework.beans.factory.config;

import lombok.Data;
import org.springframework.beans.PropertyValues;

/**
 * bean定义
 *
 * @author zhengxin
 * @since 1.0.0
 */
@Data
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;



    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

}
