package com.hellowd.cms.web;

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

	@RequestMapping("/main")
	public String main() throws Exception {
		return "layout";
	}

	@RequestMapping("/list")
	public String list() throws Exception {
		return "cmsList";
	}

	@RequestMapping("/calculate")
	public String calculate() throws Exception {
		return "cmsCalculate";
	}
}
