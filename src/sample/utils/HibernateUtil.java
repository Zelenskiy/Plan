package sample.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import sample.models.PlanEntity;

public class HibernateUtil {
    private static final  SessionFactory sessionFactory;
    private static final  ServiceRegistry serviceRegistry;
    static {
        try {
            Configuration config = getConfiguration();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    config.getProperties()).buildServiceRegistry();
            config.setSessionFactoryObserver(new SessionFactoryObserver() {
                private static final long  serialVersionUID = 1L;

                @Override
                public void sessionFactoryCreated(SessionFactory factory) {
                }

                @Override
                public void sessionFactoryClosed(SessionFactory factory) {
                    ServiceRegistryBuilder.destroy(serviceRegistry);
                }
            });
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static  Session openSession() {
        return sessionFactory.openSession();
    }

    private static  Configuration getConfiguration() {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(PlanEntity.class );
        cfg.setProperty("hibernate.connection.driver_class",     "org.hibernate.dialect.FirebirdDialect");
        cfg.setProperty("hibernate.connection.url","jdbc:firebirdsql:localhost/3050:d:/MyDoc/projects_java/Plan1/WebContent/Base/BASE.FDB?autoReconnect=true");
        cfg.setProperty("hibernate.connection.username", "SYSDBA");
        cfg.setProperty("hibernate.connection.password", "masterkey");
        cfg.setProperty("hibernate.show_sql", "true");
        //cfg.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        cfg.setProperty("hibernate.cache.provider_class","org.hibernate.cache.NoCacheProvider");
        cfg.setProperty("hibernate.current_session_context_class", "thread");
        return cfg;
    }
}
