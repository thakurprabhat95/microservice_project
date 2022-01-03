package com.shippingservice.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "shippingclient",url = "http://localhost:8083/account")//url from account-service
public interface ShippingFeignClient {
	
	
	@GetMapping("getallaccount")//http://localhost:8083/getallaccount
	public String getAccountDetail();
	
	
	

}
