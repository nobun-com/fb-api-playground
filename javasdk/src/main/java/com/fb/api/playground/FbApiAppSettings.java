package com.fb.api.playground;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FbApiAppSettings {

	@Value("${fb.api.ad.account.id}")
	private String adAccountId = "";
	
	@Value("${fb.api.access.token}")
	private String accessToken = "";
	
	@Value("${fb.api.app.secret}")
	private String appSecret = "";

	public String getAdAccountId() {
		return adAccountId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getAppSecret() {
		return appSecret;
	}
	
}
