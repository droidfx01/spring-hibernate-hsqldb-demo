package net.droidfx.springHibernateHsqldbDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "net.droidfx.springHibernateHsqldbDemo.repository")
@Import(JPAConfig.class)
public class AppContext {

}
