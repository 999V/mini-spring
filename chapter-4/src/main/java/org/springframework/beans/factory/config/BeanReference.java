package org.springframework.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * bean引用
 *
 * @author zhengxin
 * @since 1.0.0
 */
@AllArgsConstructor
@Data
public class BeanReference {

    private final String beanName;

}
