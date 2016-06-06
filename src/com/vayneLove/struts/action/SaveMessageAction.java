/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.vayneLove.struts.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.vayneLove.domain.Message;
import com.vayneLove.service.AddMessageservice;
import com.vayneLove.struts.form.MessageForm;

/** 
 * MyEclipse Struts
 * Creation date: 06-06-2016
 * 
 * XDoclet definition:
 * @struts.action path="/saveMessage" name="messageForm" scope="request"
 */
public class SaveMessageAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		MessageForm messageForm = (MessageForm) form;
		Message message = new Message();
		message.setId((long)1);
		message.setSender(messageForm.getSender());
		message.setContent(messageForm.getContent());
		message.setGetter(messageForm.getGetter());
		message.setSendTime("2016-6-6");
		message.setAttachment("fujian");
		System.out.println(message.getSendTime().toString());
		System.out.println(message.getSender().toString());
		System.out.println(message.getGetter().toString());
		System.out.println(message.getContent().toString());
		System.out.println(message.getId().toString());
		System.out.println(message.getAttachment().toString());
		AddMessageservice addMessageservice = new AddMessageservice();
		addMessageservice.sendMessage(message);
		return mapping.findForward("addOk");
	}
}