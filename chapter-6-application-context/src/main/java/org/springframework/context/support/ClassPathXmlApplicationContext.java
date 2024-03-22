package org.springframework.context.support;

import org.spring.common.exception.BeansException;

/**
 * 类路径xml应用程序上下文
 * <P>ClassPathXmlApplicationContext，是具体对外给用户提供的应用上下文方法。
 * 在继承了 AbstractXmlApplicationContext 以及层层抽象类的功能分离实现后，
 * 在此类 ClassPathXmlApplicationContext 的实现中就简单多了，主要是对继承抽象类中方法的调用和提供了配置文件地址信息。
 *
 *
 * @author zhengxin
 * @see AbstractXmlApplicationContext
 * @since 1.0.0
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }


    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations 配置位置
     * @throws BeansException Beans异常
     */
    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }


    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations 配置位置
     * @throws BeansException Beans异常
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }


    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}
