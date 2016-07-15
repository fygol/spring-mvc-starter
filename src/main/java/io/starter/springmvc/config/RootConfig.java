package io.starter.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "io.starter.springmvc.service",
    "io.starter.springmvc.repository"}
)
public class RootConfig {
}

