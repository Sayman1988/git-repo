package localhost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

import java.util.Properties;

import static localhost.Application.getInstanceConfig;


/**
 * @author Oleksandr Serogin
 */
@Configuration
public class Config {
    @Bean
    public JndiObjectFactoryBean connectionFactory() {
        Properties prop = getInstanceConfig();
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName(prop.getProperty("jndi.connections.factory.name"));
        jndiObjectFactoryBean.setJndiEnvironment(prop);
        return jndiObjectFactoryBean;
    }

}
