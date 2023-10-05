package com.softexpert.desafiosoftexpert.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.softexpert.desafiosoftexpert.service.resourceout")
public class FeignConfig  {
}
