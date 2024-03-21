package org.springframework.core.io;

import org.spring.common.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


/**
 * classPath resource
 * <P>通过 ClassLoader 读取ClassPath 下的文件信息</P>
 *
 * @author zhengxin
 * @see Resource
 * @since 1.0.0
 */
public class ClassPathResource implements Resource {

    /**
     * 路径
     */
    private final String path;

    /**
     * 类加载器
     */
    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is;
    }

}
