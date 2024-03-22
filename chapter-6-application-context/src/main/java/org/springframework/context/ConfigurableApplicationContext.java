package org.springframework.context;

import cn.hutool.core.bean.BeanException;

/**
 * 可配置应用程序上下文
 * <P>ConfigurableApplicationContext 继承自 ApplicationContext，并提供了 refresh 这个核心方法。
 * 如果你有看过一些 Spring 源码，那么一定会看到这个方法。 接下来也是需要在上下文的实现中完成刷新容器的操作过程</P>
 * @author zhengxin
 * @see ApplicationContext
 * @since 1.0.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新
     *
     * @throws BeanException bean异常
     */
    void refresh() throws BeanException;

}
