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
import com.vayneLove.utils.DealDate;

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
		message.setSender(messageForm.getSender());
		message.setContent(messageForm.getContent());
		message.setGetter(messageForm.getGetter());
		message.setSendTime(DealDate.dateFomat(new Date()));
		message.setAttachment("fujian");
		AddMessageservice addMessageservice = new AddMessageservice();
		addMessageservice.sendMessage(message);
		request.getSession().setAttribute("testSession", message.getContent());
		return mapping.findForward("addOk");
	}
}