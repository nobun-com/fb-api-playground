package com.fb.api.playground.service.impl;

import org.springframework.stereotype.Component;

import com.fb.api.playground.service.PlaygroundService;

@Component
public class PlaygroundServiceImpl implements PlaygroundService {

	@Override
	public String ping() {
		return "ping success";
	}
	
}
