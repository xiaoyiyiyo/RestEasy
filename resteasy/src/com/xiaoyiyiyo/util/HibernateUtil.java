package com.xiaoyiyiyo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by xiaoyiyiyo on 2017/2/19.
 */
public class HibernateUtil {
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static final SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

    private HibernateUtil(){}

    public static Session getSession(){
        Session session = threadLocal.get();
        if(session == null){
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

    public static void closeSession(){
        Session session = threadLocal.get();
        threadLocal.set(null);
        if(session != null){
            session.close();
        }
    }
}
