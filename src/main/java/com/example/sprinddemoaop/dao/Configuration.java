package com.example.sprinddemoaop.dao;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@org.springframework.context.annotation.Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.example.sprinddemoaop.dao")
public class Configuration {
    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/instructions_shema?useSSL=false";
    private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
    private final static String DATABASE_USER = "root";
    private final static String DATABASE_PASSWORD = "Eldar2001";

    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USER);
        dataSource.setPassword(DATABASE_PASSWORD);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(DataSource dataSource){
        LocalSessionFactoryBean  sessionFactoryBuilder = new LocalSessionFactoryBean ();
        sessionFactoryBuilder.setDataSource(dataSource);
        sessionFactoryBuilder.setAnnotatedClasses(new Class[] { Account.class });
        sessionFactoryBuilder.setPackagesToScan(
                new String[] { "src.main.java.com.example.sprinddemoaop.dao" });
        return sessionFactoryBuilder;
    }

    private Properties getHibernateProperties(){
        Properties properties = new Properties();

        properties.put("hibernate.dialect", DATABASE_DIALECT);
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }

}
