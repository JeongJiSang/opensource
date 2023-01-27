package com.jbground.source.database.utils;

import java.util.HashMap;
import java.util.Map;

import com.toy.uiserver.database.model.Machine;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author imssbora
 */
public class HibernateUtil {

    private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            synchronized (SessionFactory.class) {
                if (sessionFactory == null) {
                    try {
                        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

                        Map<String, Object> settings = new HashMap<>();
                        settings.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
                        settings.put(Environment.URL, "jdbc:oracle:thin:@127.0.0.1:1521:orcl");
                        settings.put(Environment.USER, "crrcmcs");
                        settings.put(Environment.PASS, "crrcmcs");
                        settings.put(Environment.HBM2DDL_AUTO, "update");
                        settings.put(Environment.SHOW_SQL, true);

                        // HikariCP settings

                        // Maximum waiting time for a connection from the pool
                        settings.put("hibernate.hikari.connectionTimeout", "20000");
                        // Minimum number of ideal connections in the pool
                        settings.put("hibernate.hikari.minimumIdle", "1");
                        // Maximum number of actual connection in the pool
                        settings.put("hibernate.hikari.maximumPoolSize", "2");
                        // Maximum time that a connection is allowed to sit ideal in the pool
                        settings.put("hibernate.hikari.idleTimeout", "300000");

                        registryBuilder.applySettings(settings);

                        registry = registryBuilder.build();
                        MetadataSources sources = new MetadataSources(registry)
                                .addAnnotatedClass(Machine.class);
                        Metadata metadata = sources.getMetadataBuilder().build();
                        sessionFactory = metadata.getSessionFactoryBuilder().build();
                        logger.info("first created", sessionFactory.toString());
                    } catch (Exception e) {
                        if (registry != null) {
                            StandardServiceRegistryBuilder.destroy(registry);
                        }
                        e.printStackTrace();
                    }
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}