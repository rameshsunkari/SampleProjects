package com.test.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/hello")
public class HelloWorld {
	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}

	// This method is called if TEXT_PLAIN is request"
	@Path("/user/{userName}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHelloUser(@PathParam("userName") String userName) {
		return "Hello " + userName + "! Welcome to Jersy " ;
	}
	
	@Path("/user")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloUser(@QueryParam("userName") String userName) {
		return "Hello " + userName + "! Welcome to Jersy " ;
	}

	// This method is called if XMLis request
	@Path(value = "/xml")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// This method is called if HTML is request
	@Path(value = "/html")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</h1></body>" + "</html> ";
	}
	
	@Path(value="/postText")
	@POST
	@Consumes("text/plain")
	public String postClichedMessage(String message) {
	    String response = "Hi Hello " + message;
		System.out.println(response);
		return response;
	}
	
	@Path(value="/postFormHtml")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String postFormDataHtml(@FormParam("name") String name) {
		return "<html> " + "<title>" + "Jersey" + "</title>"
				+ "<body><h1>" + "Hello " + name + "! Welcome to Jersy</h1></body>" + "</html> ";
	
	
	}
	
	
	@Path(value="/postFormText")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String postFormDataText(@FormParam("name") String name) {
		return "Hello " + name + "! Welcome to Jersy";
	
	
	}

	
	@POST
	@Path("/add")
	public Response addUser(
		@FormParam("name") String name,
		@FormParam("age") int age) {
 
		return Response.status(200)
			.entity("addUser is called, name : " + name + ", age : " + age)
			.build();
 
	}
}
