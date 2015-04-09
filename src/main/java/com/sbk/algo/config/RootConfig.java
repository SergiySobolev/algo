package com.sbk.algo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan("com.sbk.algo")
@Import(DataBaseConfig.class)
public class RootConfig {
}
