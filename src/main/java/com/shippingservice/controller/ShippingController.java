package com.shippingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shippingservice.FeignClient.ShippingFeignClient;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
	
	@Autowired
	ShippingFeignClient shippingFeign;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	//intercommunication using feign client
	@GetMapping("/getallaccountfromshiiping")//call http://localhost:8083/getallaccount
	public String getAccountFromShipping()
	{
		return shippingFeign.getAccountDetail();
	}
	
	//intercommunication using restTemplate
//	@GetMapping("/getaccountDetaild")
//	public String getAccountDetails()
//	{
//		return restTemplate.getForObject("http://localhost:8083/account/getaccountbyname",String.class);
//	}
//	
//	@GetMapping("/getaccountbyid/{id}")
//	public String getAccountDetailsById(@PathVariable("id") Integer id)
//	{
//		return restTemplate.getForObject("http://localhost:8083/account/getAccountById/"+id, String.class);
//	}
//	
	
	//intercommunication using rest Template
	
	@GetMapping("/getaccountusingrest")
	public String getAccountUsingRest()
	{
		return restTemplate.getForObject("http://localhost:8083/account/getallaccount", String.class);
	}
	
	@GetMapping("/getaccountById/{id}")
	public String getAccountDetailsById(@PathVariable("id") Integer id)
	{
		return restTemplate.getForObject("http://localhost:8083/account/getAccountById/"+id, String.class);
	}
	
	
	
	//http://localhost:8083/account/getAccountById/9
//	@GetMapping("/getallshipping")
//	public String getAllAcount()
//	{
//		return "this is shiiping service";
//	}

	//inter-communication using restTempltate
	//config-server
	//api-gateway
	//hystrix
	//zipkin server
	//load balancer--Ribbon
	//sonarcube
	
	
	
}
