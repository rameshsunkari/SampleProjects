package com.thinkadv.springmvc.pivotol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/projects")
public class ProjectsController {
	
	@RequestMapping(value="/list",method = RequestMethod.GET) 
	public String listProjects(ModelMap model){
		
		model.addAttribute("message", "Spring 4 MVC Hello World");
		return "projectsList";
		
	}

}
