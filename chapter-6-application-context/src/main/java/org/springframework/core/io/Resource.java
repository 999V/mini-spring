package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载接口
 *
 * @author zhengxin
 * @since 1.0.0
 */
public interface Resource {

    /**
     * 提供获取 InputStream 流的方法，接下来再分别实现三种不同的流文件操作：classPath、FileSystem、URL
     *
     * @return {@code InputStream }
     * @throws java.io.IOException IOException
     */
    InputStream getInputStream() throws IOException;

}
