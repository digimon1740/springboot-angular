package com.hellowd.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/")
	public String home() throws Exception {
		return "hello";
	}

	@RequestMapping("/success")
	public String login() throws Exception {
		return "layout";
	}

}
