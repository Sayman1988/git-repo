package localhost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;


import java.io.IOException;
import java.util.Properties;

/**
 * @author Oleksandr Serogin
 */
@SpringBootApplication(exclude = JmxAutoConfiguration.class)
@EnableJms
public class Application {
    public static Properties getInstanceConfig() {
        try {
            Properties p = new Properties();
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jms/config.properties"));
            return p;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
