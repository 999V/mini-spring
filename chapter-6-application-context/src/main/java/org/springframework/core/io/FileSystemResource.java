package org.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * 文件系统资源
 * <p>通过指定文件路径的方式读取文件信息</p>
 *
 * @author zhengxin
 * @see org.springframework.core.io.Resource
 * @since 1.0.0
 */
public class FileSystemResource implements Resource {

    private final File file;

    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(this.file.toPath());
    }

    public final String getPath() {
        return this.path;
    }
}
