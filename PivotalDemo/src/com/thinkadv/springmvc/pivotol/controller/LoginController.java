package com.thinkadv.springmvc.pivotol.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.thinkadv.springmvc.pivotol.model.LoginForm;
import com.thinkadv.springmvc.pivotol.model.UserToken;

@Controller
public class LoginController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String showForm(Map<String, LoginForm> model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginForm";
	}

	@RequestMapping(value="/loginAction",method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map<String, LoginForm> model, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "loginForm";

		}
		loginForm = (LoginForm) model.get("loginForm");

		

		if (!isValidUser(loginForm, request)) {
			return "loginError";
		}

		model.put("loginForm", loginForm);
		return "loginSuccess";
	}
	
	private boolean isValidUser(LoginForm loginForm, HttpServletRequest request) {
		boolean isValid = false;
		String username = loginForm.getUserName();
		String password = loginForm.getPassword();
		
		String plainCreds = username + ":"+password;
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		
		
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
	    acceptableMediaTypes.add(MediaType.APPLICATION_XML);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_XML);
	    headers.setAccept(acceptableMediaTypes);
	    headers.add("Authorization", "Basic " + base64Creds);
	    
	    HttpEntity<UserToken> getTokenRequest = new HttpEntity<UserToken>(headers);

		
		
		ResponseEntity<UserToken> response = restTemplate.exchange("https://www.pivotaltracker.com/services/v3/tokens/active", HttpMethod.GET, getTokenRequest, UserToken.class);
		
		if(response != null && 200 == response.getStatusCode().value()) {
			request.getSession().setAttribute("X-TrackerToken", response.getBody().getGuid());
			return true;
		}
		
		return isValid;
	}
}
