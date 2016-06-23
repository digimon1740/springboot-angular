package com.hellowd.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SangHoon, Lee(devsh@helloworlds.co.kr)
 */
@RestController
@RequestMapping("/")
public class CmsController extends RootController {

	private Logger logger = LoggerFactory.getLogger(getClass());
}
