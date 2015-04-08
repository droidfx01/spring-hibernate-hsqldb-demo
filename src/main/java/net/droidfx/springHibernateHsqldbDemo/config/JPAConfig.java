package net.droidfx.springHibernateHsqldbDemo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

public class JPAConfig {

	final Logger log = LoggerFactory.getLogger(JPAConfig.class);

	// Testing in-memory datasource
	// @Bean(name = "dataSource")
	// public DataSource getDatasource() {
	// return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
	// .build();
	// }

	// File datasource
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:file:${user.home}/db/data;shutdown=true");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("net.droidfx.springHibernateHsqldbDemo.entity");
		emf.setPersistenceUnitName("");
		emf.setPersistenceUnitName("JPA");

		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		emf.setJpaVendorAdapter(jpaVendorAdapter);

		return emf;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
