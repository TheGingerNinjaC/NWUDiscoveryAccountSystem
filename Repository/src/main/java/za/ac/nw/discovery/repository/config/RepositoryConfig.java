package za.ac.nw.discovery.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nw.discovery.repository.persistence")
@EntityScan("za.ac.nw.discovery.domain.persistence")
@PropertySource(value = "classpath:application-db.properties")
public class RepositoryConfig {

//    private static final String[] ENTITY_PACKAGES_TO_SCAN = {"za.ac.nw.discovery.domain.persistence"};
//    private static final String PERSISTENCE_UNIT_NAME = "account.system.persistence";
//
//    @Value("${spring.datasource.url}")
//    private String datasourceUrl;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES_TO_SCAN);
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManagerFactoryBean.setJpaProperties(buildJpaProperties());
//        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
//
//        return entityManagerFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//
//        return transactionManager;
//    }
//
//    @Bean
//    public JdbcTemplate getJdbcTemplate(){
//        return new JdbcTemplate((dataSource()));
//    }
//
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//        try {
//            SQLServerDataSource datasource = new SQLServerDataSource();
//            datasource.setUser(username);
//            datasource.setPassword(password);
//            datasource.setURL(datasourceUrl);
//            return dataSource;
//        }
//        catch (Exception ex)
//        {
//            throw new RuntimeException("Unable to connect to the DB", ex);
//        }
//    }
//
//    public Properties buildJpaProperties(){
//        Properties properties = new Properties();
//        properties.setProperty("javax.persistence.transactionType", "jta");
//        properties.setProperty("hibernate.Integercode.use_reflection_optimizer", "true");
//
//        return properties;
//    }

}
