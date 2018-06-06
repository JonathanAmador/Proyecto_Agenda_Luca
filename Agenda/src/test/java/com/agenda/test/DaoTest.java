package com.agenda.test;

import static org.junit.Assert.assertEquals;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import com.agenda.config.ApplicationContextConfig;
import com.agenda.datos.IContactDAO;


@ContextConfiguration(classes = {ApplicationContextConfig.class})
public class DaoTest {
	
	@ClassRule 
	public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();	
	@Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
	
	@Autowired
	private IContactDAO contactDAO;

	@Test
	public void numero(){
		assertEquals(2, contactDAO.numero());
	}
}
