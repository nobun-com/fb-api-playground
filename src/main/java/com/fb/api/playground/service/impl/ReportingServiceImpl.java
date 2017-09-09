package com.fb.api.playground.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facebook.ads.sdk.*;
import com.facebook.ads.sdk.AdsInsights.EnumBreakdowns;
import com.fb.api.playground.FbApiAppSettings;
import com.fb.api.playground.service.ReportingService;

@Component
public class ReportingServiceImpl implements ReportingService {

	@Autowired
	private FbApiAppSettings appSettings = null;

	/**
	 * Sandbox ad account ID : 100754067293346 Level : campaign Columns :
	 * results,cost_per_result Filters :
	 * [{"field":"delivery_info","operator":"IN","value":... Breakdowns :
	 * ["age","gender"] Date Range : {"since":"2017-01-01","until":"2017-02-01"}
	 *
	 * @return
	 */
	@Override
	public String getCampaignReport() {
		APIContext context = new APIContext(appSettings.getAccessToken()).enableDebug(true);
		try {
			List<EnumBreakdowns> breakDownsList = new ArrayList<>(
				    Arrays.asList(EnumBreakdowns.VALUE_AGE, EnumBreakdowns.VALUE_GENDER));
			
			APINodeList<AdsInsights> adsInsightsList = new AdAccount(appSettings.getAdAccountId(), context).getInsights()
					.setTimeRange("{\"since\":\"2016-01-01\",\"until\":\"2017-02-01\"}")
					//.setFiltering("[{\"field\":\"delivery_info\",\"operator\":\"IN\",\"value\":[\"active\",\"limited\",\"scheduled\",\"completed\",\"recently_completed\"]}]")
					.setLevel(AdsInsights.EnumLevel.VALUE_CAMPAIGN)
					.setBreakdowns(breakDownsList)
					//.requestField("results")
					//.requestField("cost_per_result")
					.execute();
			return adsInsightsList.toString();
		} catch (APIException e) {
			return e.getLocalizedMessage();
		}
	}

}
