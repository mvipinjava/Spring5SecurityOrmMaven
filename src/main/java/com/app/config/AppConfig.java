
package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.app")
@PropertySource("classpath:app.properties")
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig {
	@Autowired
	private Environment env;


	//1. DataSource
	@Bean
	public BasicDataSource ds() {
		BasicDataSource d=new BasicDataSource();
		d.setDriverClassName(env.getProperty("db.driver"));
		d.setUrl(env.getProperty("db.url"));
		d.setUsername(env.getProperty("db.un"));
		d.setPassword(env.getProperty("db.pwd"));
		return d;
	}
	//2. SessionFactory
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean l=new LocalSessionFactoryBean();
		l.setDataSource(ds());//ref type
		//l.setAnnotatedClasses(Employee.class,User.class);
		
		/**
		 *  This one will select classes 
		 *  from given package
		 *  and creates tables in DB 
		 *  using ORM Mapping
		 **/
		l.setPackagesToScan("com.app.model");
		
		
		l.setHibernateProperties(props());
		return l;
	}
	@Bean
	public Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect",env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql",env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql",env.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto",env.getProperty("orm.ddlauto"));
		return p;
	}
	
	
	//3. HT
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sf().getObject());
		return ht;
	}
	//4. HTxM
	@Bean
	public HibernateTransactionManager htx() {
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sf().getObject());
		return htm;
	}
	
	//5. ViewResolver
	@Bean
	public InternalResourceViewResolver vr() {
		InternalResourceViewResolver v=new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("mvc.prefix"));
		v.setSuffix(env.getProperty("mvc.suffix"));
		return v;
	}
	
	
	/**** Spring Security ***/
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}