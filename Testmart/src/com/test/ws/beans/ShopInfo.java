package com.test.ws.beans;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


@WebService
@SOAPBinding(style=Style.RPC)
public class ShopInfo {

	@WebMethod
	@WebResult(partName="lookupoutput")
	public String getShopInfo(@WebParam(partName="lookupInput") String property){
		String response="Invalid Property";
		
		if ("shopname".equals(property))
			response = "Test Mart";

		else if ("since".equals(property))
			response = "Test Mart";
		
		return response;
	}
}
