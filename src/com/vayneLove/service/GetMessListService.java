package com.vayneLove.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vayneLove.domain.Message;
import com.vayneLove.utils.HibernateTools;

public class GetMessListService {
	
	@SuppressWarnings("unchecked")
	public List<Message> getmessagesList(){

			List<Message> lists = HibernateTools.executeQuery("From Message");
			
			return lists;

		
		
	}

}
