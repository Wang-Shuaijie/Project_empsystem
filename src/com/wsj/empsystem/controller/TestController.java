package com.wsj.empsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * ≤‚ ‘¿‡
 * @author WangShuaiJie
 *
 */
@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping("test")
	public String myTag() {
		return "test";
	}
}
