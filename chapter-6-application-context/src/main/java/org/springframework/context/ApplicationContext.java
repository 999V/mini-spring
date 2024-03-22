package org.springframework.context;

import org.springframework.beans.factory.ListableBeanFactory;

/**
 * 应用程序上下文
 * <p>ApplicationContext，继承于 ListableBeanFactory，也就继承了关于 BeanFactory 方法，比如一些 getBean 的方法。
 * 另外 ApplicationContext 本身是 Central 接口，但目前还不需要添加一些获取ID和父类上下文，所以暂时没有接口方法的定义</p>
 *
 * @author zhengxin
 * @see ListableBeanFactory
 * @since 1.0.0
 */
public interface ApplicationContext extends ListableBeanFactory {




}
