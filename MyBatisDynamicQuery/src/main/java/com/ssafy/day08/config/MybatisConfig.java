package com.ssafy.day08.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ssafy.day08.dao")
public class MybatisConfig {
	// ... XXXXX
}
