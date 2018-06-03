package com.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agenda.model.Contact;
import com.agenda.services.IContactServices;

@Controller
public class ContactController { // SearchListContact

	@Autowired
	private IContactServices contactServices;

	@RequestMapping("/")
	public ModelAndView handlesRequest() throws Exception {
		List<Contact> listContact = contactServices.searchListContact();
		ModelAndView model = new ModelAndView("ContactList");
		model.addObject("contactList", listContact);
		return model;
	}
	
}
