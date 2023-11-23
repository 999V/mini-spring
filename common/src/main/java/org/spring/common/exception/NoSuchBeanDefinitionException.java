package org.spring.common.exception;

/**
 * 没有bean定义异常
 *
 * @author zhengxin
 * @see BeansException
 * @since 1.0.0
 */
public class NoSuchBeanDefinitionException extends BeansException {

        private String beanName;

        public NoSuchBeanDefinitionException(String beanName) {
            super("No bean named '" + beanName + "' available");
            this.beanName = beanName;
        }

        public NoSuchBeanDefinitionException(String beanName, String msg) {
            super("No bean named '" + beanName + "' available: " + msg);
            this.beanName = beanName;
        }

        public NoSuchBeanDefinitionException(String beanName, String msg, Throwable cause) {
            super("No bean named '" + beanName + "' available: " + msg, cause);
            this.beanName = beanName;
        }

        public String getBeanName() {
            return this.beanName;
        }

}
