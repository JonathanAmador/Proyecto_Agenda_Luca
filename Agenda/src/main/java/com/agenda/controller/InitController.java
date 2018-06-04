package com.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/")
public class InitController {

	@GetMapping()
	public ModelAndView inicio(ModelMap model) {
		ModelAndView mav = new ModelAndView("resultListContact");   
        System.out.println("entraaaaaaaaaaaaaaaaaaa");
        return mav;
	}
	
}
