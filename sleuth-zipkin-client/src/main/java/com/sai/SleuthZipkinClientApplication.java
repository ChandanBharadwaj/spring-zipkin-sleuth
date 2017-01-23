package com.sai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




@Configuration
class Config{
	@Bean
	public RestTemplate getRestTemplate() {
	    return new RestTemplate();
	}
	@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	}
}

@RestController
class MyController{
	private static final Logger log = LoggerFactory.getLogger(MyController.class);
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String get(){
		log.info("get Method is called");
		return "This Is Response";
	}
	@RequestMapping(value="/callGet", method=RequestMethod.GET)
	public String callGet(){
		log.info("callGet Method is called");
		String p=restTemplate.getForObject("http://localhost:8060/", String.class);
		return p;
	}
}


@SpringBootApplication
public class SleuthZipkinClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthZipkinClientApplication.class, args);
	}
}
