package com.thinkadv.springmvc.pivotol.controller;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String showForm(Map<String, LoginForm> model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginForm";
	}

	@RequestMapping(value="/loginAction",method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map<String, LoginForm> model) {

		if (result.hasErrors()) {
			return "loginForm";

		}
		loginForm = (LoginForm) model.get("loginForm");

		

		if (!isValidUser(loginForm)) {
			return "loginError";
		}

		model.put("loginForm", loginForm);
		return "loginSuccess";
	}
	
	private boolean isValidUser(LoginForm loginForm) {
		boolean isValid = false;
		String username = loginForm.getUserName();
		String password = loginForm.getPassword();
		
		String plainCreds = username + ":"+password;
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<UserToken> response = restTemplate.exchange("https://www.pivotaltracker.com/services/v3/tokens/active", HttpMethod.GET, request, UserToken.class);
		isValid = "200".equals(response.getStatusCode());
		
		return isValid;
	}
}
