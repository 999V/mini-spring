package org.spring.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户
 *
 * @author zhengxin
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class User {

    private String id;

    private String name;

    private Integer age;

}
