package com.agenda.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.agenda.model.Personas;
import com.agenda.services.IContactServices;

@Controller
public class ContactController { // SearchListContact

	@Autowired
	private IContactServices contactServices;
	
	

	@RequestMapping("/")
	public ModelAndView handlesRequest() throws Exception {
		System.out.println("PASO 1 ");
		List<Personas> listContact = contactServices.searchListContact();
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
		Personas contact = (Personas) contactServices.get(idPerson);
		ModelAndView model = new ModelAndView("resultContact");
		model.addObject("contact", contact);
		return model;

		
	}
	
	@RequestMapping(value="/showListContact", method = RequestMethod.POST)
	public ModelAndView listContactFilter(HttpServletRequest request) throws Exception {
	
		String cadena = request.getParameter("consulta");
		
		System.out.println("PASO 1: busqueda:"+cadena);
		List<Personas> listContact = contactServices.searchListCategory(cadena);
		System.out.println("PASO 2 filtrado");
		ModelAndView model = new ModelAndView("resultListContact");
		System.out.println("PASO 3 filtrado");
		model.addObject("listContact", listContact);
		System.out.println("PASO 4 flitrado");
		return model;
	}
	
	@RequestMapping(value="/showCategory", method = RequestMethod.GET)
	public ModelAndView ListContactCategory(HttpServletRequest request) throws Exception {
		String categoria = request.getParameter("categoria");
		
		List<Personas> listContact = contactServices.searchListContact(categoria);
		
		ModelAndView model = new ModelAndView("resultListContact");
		
		model.addObject("listContact", listContact);
		
		return model;
	}
	
	
	/*
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model = new ModelAndView("UserForm");
		model.addObject("user", new Contact());
		return model;		
	}
	*/
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("ID:"+userId);
		
		Personas contact = contactServices.get(userId);
		System.out.println("Cogiendo usuario:"+contact.getNombre());
		ModelAndView model = new ModelAndView("newContact");
		model.addObject("contact", contact);
		return model;		
	}
	
	/*
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
