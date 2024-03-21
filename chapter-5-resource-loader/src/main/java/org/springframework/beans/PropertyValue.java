package org.springframework.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 属性
 *
 * @author zhengxin
 * @since 1.0.0
 */
@AllArgsConstructor
@Data
public class PropertyValue {

    private final String name;

    private final Object value;


}
