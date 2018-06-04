package com.agenda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.agenda.model.Contact;
import com.agenda.services.IContactServices;

@Controller
public class ContactController { // SearchListContact

	@Autowired
	private IContactServices contactServices;
	
	

	@RequestMapping("/")
	public ModelAndView handlesRequest() throws Exception {
		System.out.println("PASO 1 ");
		List<Contact> listContact = contactServices.searchListContact();
		System.out.println("PASO 2");
		ModelAndView model = new ModelAndView("resultListContact");
		System.out.println("PASO 3");
		model.addObject("listContact", listContact);
		System.out.println("PASO 4");
		return model;
	}
	
	@RequestMapping(value ="/showContact", method = RequestMethod.GET)
	public ModelAndView contactInfo(HttpServletRequest request){
		int idPerson = Integer.parseInt(request.getParameter("id"));
		Contact contact = (Contact) contactServices.searchContact(idPerson);
		ModelAndView model = new ModelAndView("resultContact");
		model.addObject("contact", contact);
		return model;

		
	}
	
	@RequestMapping("/showListContact")
	public ModelAndView listContactFilter() throws Exception {
		System.out.println("PASO 1 filtrado");
		List<Contact> listContact = contactServices.searchListContact("SQL");
		System.out.println("PASO 2 filtrado");
		ModelAndView model = new ModelAndView("resultListContact");
		System.out.println("PASO 3 filtrado");
		model.addObject("listContact", listContact);
		System.out.println("PASO 4 flitrado");
		return model;
	}
	
	
	
	/*
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", new Contact());
		return model;		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactServices.get(contactId);
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", contact);
		return model;		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		contactServices.delete(contactId);
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute Contact contact) {
		contactServices.saveOrUpdate(contact);
		return new ModelAndView("redirect:/");
	}*/
	
}
