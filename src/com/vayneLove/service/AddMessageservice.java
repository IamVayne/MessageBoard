package com.vayneLove.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vayneLove.domain.Message;
import com.vayneLove.utils.HibernateTools;

public class AddMessageservice {
	
	public void sendMessage(Message message){
		
		Session session=null;
		Transaction transaction=null;
		
		try {
			
			session = HibernateTools.getcurrentSession();
			transaction = session.beginTransaction();
			
			session.save(message);
			System.out.println("在session.save之后");
			
			transaction.commit();
			System.out.println("commit之后");
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
