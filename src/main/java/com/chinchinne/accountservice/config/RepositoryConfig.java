//package com.chinchinne.accountservice.config;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.MongoTransactionManager;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.data.transaction.ChainedTransactionManager;
//import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import javax.persistence.EntityManagerFactory;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.chinchinne.accountservice.repository.jpa")
//@EnableMongoRepositories(basePackages = "com.chinchinne.accountservice.repository.mongo")
//public class RepositoryConfig
//{
//    @Bean
//    public JtaTransactionManager transactionManager() {
//        return new JtaTransactionManager();
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        // JPA 설정
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource());
//        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        emf.setPackagesToScan("com.example.entity.jpa");
//        emf.setPersistenceUnitName("jpaPersistenceUnit");
//        emf.afterPropertiesSet();
//        return emf.getObject();
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        // MongoDB 설정
//        return new MongoTemplate(mongoClient(), "databaseName");
//    }
//
//    @Bean
//    public MongoClient mongoClient() {
//        MongoClient mongoClient = MongoClients.create();
//        return mongoClient;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        // 데이터베이스 설정
//        return new JndiDataSourceLookup().getDataSource("java:jboss/datasources/ExampleDS");
//    }
//}
