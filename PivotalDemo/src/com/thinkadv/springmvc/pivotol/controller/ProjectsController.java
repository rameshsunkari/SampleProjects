package com.thinkadv.springmvc.pivotol.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.thinkadv.springmvc.pivotol.model.Projects;

@Controller
@RequestMapping("/projects")
public class ProjectsController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listProjects(ModelMap model, HttpServletRequest request) {

		model.addAttribute("message", "Spring 4 MVC Hello World");

		String tokenAttribute = (String) request.getSession().getAttribute(
				"X-TrackerToken");

		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.setAccept(acceptableMediaTypes);
		headers.add("X-TrackerToken", tokenAttribute);

		HttpEntity<Projects> getTokenRequest = new HttpEntity<Projects>(headers);

		ResponseEntity<Projects> response = restTemplate.exchange(
				"http://www.pivotaltracker.com/services/v3/projects",
				HttpMethod.GET, getTokenRequest, Projects.class);
		model.put("name", response.getBody().getProject().getName());
		
		ModelAndView modelView = new ModelAndView("projectsList", "message",
				"Project Info List");
		
		modelView.addObject("projectInfoList", response.getBody());
		return modelView;

	}

}
