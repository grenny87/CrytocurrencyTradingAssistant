package org.detectpumpingcoin.forecast;

import java.util.List;

import org.detectpumpingcoin.entity.MarketHistory;
import org.detectpumpingcoin.entity.MarketSummary;

public class PumpingCoinForecastParam {
	
	private List<MarketSummary> marketSummaries;
	
	private List<MarketHistory> marketHistory;

	public List<MarketHistory> getMarketHistory() {
		return marketHistory;
	}

	public void setMarketHistory(List<MarketHistory> marketHistory) {
		this.marketHistory = marketHistory;
	}

	public List<MarketSummary> getMarketSummaries() {
		return marketSummaries;
	}

	public void setMarketSummaries(List<MarketSummary> marketSummaries) {
		this.marketSummaries = marketSummaries;
	}
	
	
	
}
