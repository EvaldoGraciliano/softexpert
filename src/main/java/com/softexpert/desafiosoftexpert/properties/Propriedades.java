package com.softexpert.desafiosoftexpert.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("pagseguro")
public class Propriedades {
    private String token;
}
