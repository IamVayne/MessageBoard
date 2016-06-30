package com.vayneLove.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vayneLove.domain.Users;
import com.vayneLove.utils.HibernateTools;

public class RegisterUserService {

	public void register(Users users)
	{
		Session session=null;
		Transaction transaction=null;
		
		try {
			
			session = HibernateTools.getcurrentSession();
			transaction = session.beginTransaction();
			
			session.save(users);
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null)
			{
				transaction.rollback();
			}
			throw new RuntimeException();
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}
}
