package com.test.ws.iplocation;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder {

	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("You need to pass one IP Address");
		} else{
			String ipAddress = args[0];
			GeoIPService ipservice = new GeoIPService();
			GeoIPServiceSoap geoIpServiceSoap = ipservice.getGeoIPServiceSoap();
			GeoIP getGeoIP = geoIpServiceSoap.getGeoIP(ipAddress);
			System.out.println(getGeoIP.getCountryName());
		}

	}

}
