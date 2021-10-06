package za.ac.nw.discovery.logic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nw.discovery.translator.config.TranslatorConfig;

@Import({TranslatorConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nw.discovery.logic.flow"
})
public class LogicConfig {
}
