package com.test.ws.rest.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JersyClientPost {

	public static void main(String[] args) {
		
		JersyClientPost obj = new JersyClientPost();
		obj.postJson();
//		obj.postText();
	}
	
	public void postJson(){
		try {
			 
			Client client = Client.create();
	 
			WebResource webResource = client
			   .resource("http://localhost:8080/RestDemo_Tomcat/rest/JSONTest/postJson");
	 
			String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
	 
			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);
	 
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}
	 
			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
	}
	
	
	public void postText(){
		try {
			 
			Client client = Client.create();
	 
			WebResource webResource = client
			   .resource("http://localhost:8080/RestDemo_Tomcat/rest/hello/postText");
	 
			String input = "Ramesh Sunkari";
	 
			ClientResponse response = webResource.type("text/plain")
			   .post(ClientResponse.class, input);
	 
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}
	 
			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);
	 
		  } catch (Exception e) {
	 
			e.printStackTrace();
	 
		  }
	}
	

}
