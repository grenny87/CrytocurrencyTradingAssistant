package org.detectpumpingcoin.entity;

public class MarketSummaryWrapper {
	private MarketSummary latestMarketSummary;
	private MarketSummary previousMarketSuammry;
	
	
	
	public MarketSummaryWrapper(MarketSummary latestMarketSummary, MarketSummary previousMarketSuammry) {
		super();
		this.latestMarketSummary = latestMarketSummary;
		this.previousMarketSuammry = previousMarketSuammry;
	}
	
	public MarketSummary getLatestMarketSummary() {
		return latestMarketSummary;
	}
	public void setLatestMarketSummary(MarketSummary latestMarketSummary) {
		this.latestMarketSummary = latestMarketSummary;
	}
	public MarketSummary getPreviousMarketSuammry() {
		return previousMarketSuammry;
	}
	public void setPreviousMarketSuammry(MarketSummary previousMarketSuammry) {
		this.previousMarketSuammry = previousMarketSuammry;
	}
	
	
}
