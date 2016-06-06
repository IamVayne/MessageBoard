package com.vayneLove.service;

import java.util.List;

import com.vayneLove.domain.Users;
import com.vayneLove.utils.HibernateTools;

public class userValidateservice {

	public boolean checkLoginer(Users user)
	{
		String hql = "from Users where name='"+user.getName()+"' and password='"+user.getPassword()+"'";  
		List list = HibernateTools.executeQuery(hql);
		if(list!=null&&list.size()==1){
			return true;
		}else {
			return false;
		}
  	}
	
}
