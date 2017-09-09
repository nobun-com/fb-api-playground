package com.fb.api.playground.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.fb.api.playground.FbApiAppSettings;
import com.fb.api.playground.service.PlaygroundService;

@Component
public class PlaygroundServiceImpl implements PlaygroundService {

	@Autowired
	private FbApiAppSettings appSettings = null;

	@Override
	public String ping() {
		return "ping success";
	}

	@Override
	public String getAccountData() {
		APIContext context = new APIContext(appSettings.getAccessToken()).enableDebug(true);
		AdAccount adAccount = new AdAccount(appSettings.getAdAccountId(), context);
		return adAccount.toString();
	}

}
