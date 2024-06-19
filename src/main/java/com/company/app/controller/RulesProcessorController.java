package com.company.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.app.service.RulesProcessingService;
import com.company.app.vo.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/srp")
public class RulesProcessorController {

	@Autowired
	private RulesProcessingService rulesProcessingService;

	@PostMapping(value = "/applyrules")
	public Customer applyMapping(@RequestBody Customer req) throws Exception {
		log.info("Request data == " + req);
		req = rulesProcessingService.applyRules(req);
		return req;
	}

}