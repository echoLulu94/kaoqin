package com.cxs.extension;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @Description: 启动类
 * @ClassName: Application 
 * @author: huimin.wu
 * @email: huimin.wu@iyomoo.com
 * @date: 2017年5月23日 
 *
 */
@SpringBootApplication
@MapperScan(basePackages = "com.cxs.extension.*.mapper")
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
