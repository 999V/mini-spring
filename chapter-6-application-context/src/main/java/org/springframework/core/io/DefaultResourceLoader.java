package org.springframework.core.io;

import org.spring.common.util.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 默认资源加载程序
 *
 * <p> 在获取资源的实现中，主要是把三种不同类型的资源处理方式进行了包装，分为：判断是否为ClassPath、URL以及文件。
 * <P> 虽然 DefaultResourceLoader 类实现的过程简单，但这也是设计模式约定的具体结果，像是这里不会让外部调用放知道过多的细节，而是仅关心具体调用结果即可
 *
 * @author zhengxin
 * @see org.springframework.core.io.ResourceLoader
 * @since 1.0.0
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            // classpath 资源
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                // url 资源
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // file 资源
                return new FileSystemResource(location);
            }
        }
    }
}
