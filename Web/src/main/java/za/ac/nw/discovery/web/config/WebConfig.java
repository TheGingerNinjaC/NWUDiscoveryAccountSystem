package za.ac.nw.discovery.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"za.ac.nw.discovery.web.controller"})
public class WebConfig {
}
