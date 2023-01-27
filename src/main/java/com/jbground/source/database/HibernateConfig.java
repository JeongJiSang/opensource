package com.jbground.source.database;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    private static Logger logger = LoggerFactory.getLogger(HibernateConfig.class);

//    @Primary
//    @Bean(name = "hikariConfig")
//    @ConfigurationProperties(prefix = "spring.datasource.hikari")
//    public static HikariConfig hikariConfig(){
//        logger.info("create HikariConfig");
//        return new HikariConfig();
//    }

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {
        logger.info("create dataSource");
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.toy.uiserver.database.model").build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory")EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

//    @Primary
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource getDataSource() throws SQLException {
//        HikariDataSource hikariDataSource = new HikariDataSource();
//        logger.info("create dataSource");
//        logger.info("pool-name         : {}", hikariDataSource.getPoolName());
//        logger.info("driver-class-name : {}", hikariDataSource.getDriverClassName());
//        logger.info("jdbc-url          : {}", hikariDataSource.getJdbcUrl());
//        logger.info("username          : {}", hikariDataSource.getUsername());
//        logger.info("password          : {}", hikariDataSource.getPassword());
//        return hikariDataSource;
//    }

//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        Map<Object, Object> targetDatasources = new HashMap<Object, Object>() {
//            private static final long serialVersionUID = 4740238371195333169L;
//            {
//                put(DataSourceType.DB1, dataSourceDB1());
//                put(DataSourceType.DB2, dataSourceDB2());
//            }
//        };
//        RoutingDataSource routingDataSource = new RoutingDataSource();
//        routingDataSource.setDefaultTargetDataSource(dataSourceDB1());
//        routingDataSource.setTargetDataSources(targetDatasources);
//        routingDataSource.afterPropertiesSet();
//        return routingDataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
//
//    @Bean(name="sqlSessionFactoryDB1")
//    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("dataSourceDB1") DataSource dataSource) throws Exception {
//        logger.debug("sqlSessionFactory", dataSource);
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/sqlite1/*.xml"));
//        String mybatisXml = null;
//        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResources(mybatisXml)[0]);
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionDB1(@Autowired @Qualifier("sqlSessionFactoryDB1") SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactoryDB);
//    }
//
//    @Bean(name="sqlSessionFactoryDB2")
//    public SqlSessionFactory sqliteSessionFactoryDB2(@Autowired @Qualifier("dataSourceDB2") DataSource dataSource)	throws Exception {
//        logger.debug("sqlSessionFactory", dataSource);
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/sqlite2/*.xml"));
//        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResources(mybatisXml)[0]);
//        return sqlSessionFactoryBean.getObject();
//    }
//    @Bean
//    public SqlSessionTemplate sqlSessionDB2(@Autowired @Qualifier("sqlSessionFactoryDB2") SqlSessionFactory factory) {
//        return new SqlSessionTemplate(factory);
//    }


//    @Bean
//    public SessionFactory sessionFactory(DataSource dataSource) throws Exception{
//        final SessionFactoryB
//    }
//
//    private final Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty(
//                "hibernate.hbm2ddl.auto", "create-drop");        hibernateProperties.setProperty(
//                "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//
//        return hibernateProperties;
//    }


}
