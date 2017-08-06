package com.fb.api.playground.controller.rest;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fb.api.playground.controller.BaseController;
import com.fb.api.playground.service.ReportingService;

@Controller
public class ReportingRestController extends BaseController {

	@Resource
	private ReportingService reportingService;
	
	@RequestMapping(value = "/get-campaign-report",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String getCampaignReport() {
		return reportingService.getCampaignReport();
	}

}
