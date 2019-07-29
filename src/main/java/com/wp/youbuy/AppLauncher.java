package com.wp.youbuy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author swiftwen
 * @date 2019年7月29日 上午11:06:37
 */
@SpringBootApplication
@MapperScan("com.wp.youbuy.mapper")
public class AppLauncher {

	public static void main(String[] args) {
		System.out.println("Hello, JavaPoet!");
		SpringApplication.run(AppLauncher.class, args);
	}
}
