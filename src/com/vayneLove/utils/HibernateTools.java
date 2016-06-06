package com.vayneLove.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTools {
	
	private static SessionFactory sessionFactory=null;
	
	private static ThreadLocal<Session> loacl = new ThreadLocal<Session>(); 
	public HibernateTools(){};

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	public static Session getcurrentSession(){
		
		Session session = loacl.get();
		
		if (session==null) {
			session = sessionFactory.openSession();
			loacl.set(session);
		}
		return session;
	}
	public static List executeQuery(String hql)
	{
		Session session = null;
		Transaction transaction=null;
		List list = null;
		try {
			session=HibernateTools.getcurrentSession();
			transaction=session.beginTransaction();
			list = session.createQuery(hql).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
				throw new RuntimeException("chucuo");
		}finally{
			if (session!=null&&session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
}
