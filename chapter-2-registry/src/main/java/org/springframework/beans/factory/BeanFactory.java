package org.springframework.beans.factory;

import org.spring.common.exception.BeansException;

public interface BeanFactory {

    /**
     * 获取bean
     *
     * @param name 名称
     * @return {@code Object }
     * @throws BeansException Beans异常
     */
    Object getBean(String name) throws BeansException;

}
