package org.detectpumpingcoin.enums;

public enum BittrexApi {
	
	GET_MARKET("/public/getmarkets"),
	GET_MARKET_SUMMARIES("/public/getmarketsummaries"),
	GET_MARKET_SUMMARY("/public/getmarketsummary"),
	GET_ORDER_BOOK("/public/getorderbook"),
	GET_TICKER("/public/getticker"),
	GET_MARKET_HISTORY("/public/getmarkethistory"),
	GET_ORDER("/account/getorder");
	
	
	private String url;
	
	BittrexApi(String url) {
		this.setUrl(url);
	}
	public String getUrl() {
		return url;
	}
	private void setUrl(String url) {
		this.url = url;
	}
}
