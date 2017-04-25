package com.message.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;

import static com.message.service.Application.getInstanceConfig;
/**
 * @author Oleksandr Serogin
 */
@Configuration
//@PropertySource("classpath:jms/config.properties")
public class Config {
    @Bean
    public JndiObjectFactoryBean connectionFactory(){
        JndiObjectFactoryBean jndiObjectFactoryBean =  new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jms/feedConnectionFactory");
        jndiObjectFactoryBean.setJndiEnvironment(getInstanceConfig());
        return jndiObjectFactoryBean;
    }
}
