package za.ac.nw.discovery.translator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nw.discovery.repository.config.RepositoryConfig;
import za.ac.nw.discovery.repository.persistence.AccountTypeRepository;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nw.discovery.translator"
})
public class TranslatorConfig {

}
