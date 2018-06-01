package com.agenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
@EnableWebMvc //mvc:annotation-driven
@Configuration
// Spring will search for annotations on classes specified 
//     in the value parameter that is passed to @ComponentScan 
@ComponentScan({ "com.agenda" })   // context:component-scan base-package="..."
public class SpringWebConfig extends WebMvcConfigurerAdapter {
	
	/*
	 * extending WebMvcConfigurerAdapter is necessary in this case to allow �resources� 
	 * (images, JavaScript, CSS etc.) to be included in the project. 
	 * To that end the addResourceHandlers() method is overridden. 
	 * */
 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
 
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
 
}
