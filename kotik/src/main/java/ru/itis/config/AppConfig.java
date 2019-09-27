package ru.itis.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

@Lazy
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("ru.itis")
@EnableAspectJAutoProxy
@Aspect
@PropertySource("classpath:ru.itis//application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Lazy
    @Autowired
    private Environment environment;

    @Lazy
    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");
        return freeMarkerConfigurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(100);
        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/").setCachePeriod(100);
        registry.addResourceHandler("/img/**").addResourceLocations("/static/img/").setCachePeriod(100);
        registry.addResourceHandler("/js/**").addResourceLocations("/static/js/").setCachePeriod(100);
    }


    @Lazy
    @Bean(name = "freeMarkerViewResolver")
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setExposeSpringMacroHelpers(true);
        viewResolver.setExposeSessionAttributes(true);
        viewResolver.setCache(true);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }

//
//    @Lazy
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setPassword(environment.getProperty("db.password"));
//        dataSource.setUsername(environment.getProperty("db.username"));
//        dataSource.setUrl(environment.getProperty("db.url"));
//        dataSource.setDriverClassName(environment.getProperty("db.driverClassName"));
//        return dataSource;
//    }
//
//    @Lazy
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("it.model");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
//
//    private Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        String[] propsNames = {"hibernate.hbm2ddl.auto", "hibernate.dialect",
//                "hibernate.show_sql"};
//        Arrays.stream(propsNames).forEach(propName ->
//                hibernateProperties.setProperty(propName,
//                        environment.getProperty(propName)));
//        return hibernateProperties;
//    }
//
//    @Lazy
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory emf, DataSource ds) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//
//        return transactionManager;
//    }
//
//    @Lazy
//    @PersistenceContext(unitName = "entityManagerFactory")
//    @Bean("entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//        em.setPackagesToScan("it.model");
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(hibernateProperties());
//        return em;
//    }
}
