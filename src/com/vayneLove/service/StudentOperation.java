package com.vayneLove.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vayneLove.domain.Students;
import com.vayneLove.utils.HibernateTools;

public class StudentOperation {

	public void addStudent(Students students) {
		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateTools.getcurrentSession();
			transaction = session.beginTransaction();

			session.save(students);
			System.out.println("在session.save之后");

			transaction.commit();
			System.out.println("commit之后");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void changeScore(String id, Short score) {
		
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateTools.getcurrentSession();
			transaction = session.beginTransaction();
			
			Students student = getOneStu(id);
			student.setScore(score);
			session.update(student);
			System.out.println("在session.save之后");

			transaction.commit();
			System.out.println("commit之后");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void deleteOneStudent(String id)
	{
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateTools.getSession();
			transaction = session.beginTransaction();
			
			Students student = getOneStu(id);
			session.delete(student);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Students getOneStu(String id)
	{
		List<Students> list = HibernateTools.executeQuery("From Students where stuid='"+id+"'");
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	public boolean findList(String id) {
		
		List<Students> list = HibernateTools.executeQuery("From Students where stuid='"+id+"'");
		
		if(list.size()>0)
		{
			System.out.println(list.get(0).getStuname());
			return true;
		}
			return false;
	}
}
