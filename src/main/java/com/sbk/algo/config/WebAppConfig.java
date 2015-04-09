package com.sbk.algo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
@ComponentScan("com.sbk.algo")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebAppConfig extends WebMvcConfigurerAdapter {

}
