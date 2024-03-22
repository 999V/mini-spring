package org.springframework.core.io;

import org.spring.common.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * url资源
 * <p>通过 HTTP 的方式读取云服务的文件</p>
 *
 * @author zhengxin
 * @see org.springframework.core.io.Resource
 * @since 1.0.0
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "URL mast not null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        } catch (IOException e) {
            if (con instanceof HttpURLConnection) {
                ((HttpURLConnection) con).disconnect();
            }
            throw e;
        }
    }
}
