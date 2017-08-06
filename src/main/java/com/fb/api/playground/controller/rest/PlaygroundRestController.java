package com.fb.api.playground.controller.rest;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fb.api.playground.controller.BaseController;
import com.fb.api.playground.service.PlaygroundService;

@Controller
public class PlaygroundRestController extends BaseController {

	@Resource
	private PlaygroundService playgroundService;
	
	@RequestMapping( value="/ping/{str}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String ping(@PathVariable("str") Long str) {
		return playgroundService.ping();
	}
}
