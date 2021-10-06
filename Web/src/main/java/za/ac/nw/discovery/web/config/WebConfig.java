package za.ac.nw.discovery.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nw.discovery.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nw.discovery.web.controller",
        "za.ac.nw.discovery.web.exception"
})
public class WebConfig {
}
