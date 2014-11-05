package com.sbk.algo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by sobik on 09.08.2014.
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.sbk.algo")
//@Import({DataBaseConfig.class})
public class WebAppConfig extends WebMvcConfigurerAdapter {

}
