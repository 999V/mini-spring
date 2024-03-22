package org.springframework.core.io;

/**
 * 资源加载器
 * <p> 按照资源加载的不同方式，资源加载器可以把这些方式集中到统一的类服务下进行处理，外部用户只需要传递资源地址即可，简化使用
 *
 * @author zhengxin
 * @since 1.0.0
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源
     *
     * @param location 地方
     * @return {@code Resource }
     */
    Resource getResource(String location);

}
