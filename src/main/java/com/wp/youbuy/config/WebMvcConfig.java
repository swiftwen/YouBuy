package com.wp.youbuy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 图片绝对地址与虚拟地址映射
 * @author swiftwen
 * @date 2019年7月29日 下午4:44:54
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Value("${virtual.file.prefix}")
    private String fileUrlPrefix;

    @Value("${virtual.file.path}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 文件磁盘图片url 映射 配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler(fileUrlPrefix).addResourceLocations(filePath);
    }

}
