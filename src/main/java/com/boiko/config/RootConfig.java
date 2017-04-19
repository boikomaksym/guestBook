package com.boiko.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.boiko.service"})
@Import(DataConfig.class)
public class RootConfig {
}
