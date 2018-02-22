package org.detectpumpingcoin.request.generator;


import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.detectpumpingcoin.consts.ApiConfiguration;
import org.detectpumpingcoin.enums.BittrexApi;
import org.detectpumpingcoin.enums.BittrexOrderType;

public class BittrexRequestGenerator {
	private static final String QUESTION_MARK = "?";
	private static final String EQUAL_MARK = "=";
	private static final String AND_MARK="&";
	private static final String MARKET_PARAM = "market";
	private static final String ORDER_TYPE_PARAM = "type";
	private static BittrexRequestGenerator instance;
	private String host;
	private String scheme;
	
	private BittrexRequestGenerator() {
		
	}
	
	public static BittrexRequestGenerator getInstance() {
		if (null == instance) {
			instance = new BittrexRequestGenerator();
		}
		instance.setHost(ApiConfiguration.BITTREX_HOST).setScheme("https");
		return instance;
	}
	
	
	public BittrexRequestGenerator setHost(String host) {
		this.host = host;
		return this;
	}
	
	public BittrexRequestGenerator setScheme(String scheme) {
		this.scheme = scheme;
		return this;
	}
	
	public String getMarketSummariesRequest() throws URISyntaxException {
		URIBuilder builder = new URIBuilder();
		builder.setScheme(scheme);
		builder.setHost(host);
		builder.setPath(ApiConfiguration.API_PATH + BittrexApi.GET_MARKET_SUMMARIES.getUrl());
		return builder.build().toString();
	}
	
	public String getMarketSummaryRequest(String market) throws URISyntaxException {
		URIBuilder builder = new URIBuilder();
		builder.setScheme(scheme);
		builder.setHost(host);
		builder.setPath(ApiConfiguration.API_PATH + BittrexApi.GET_MARKET_SUMMARY.getUrl());
		builder.addParameter(MARKET_PARAM, market);
		return builder.build().toString();
	}
	
	public String getMarketHistoryRequest(String market) throws URISyntaxException {
		URIBuilder builder = new URIBuilder();
		builder.setScheme(scheme);
		builder.setHost(host);
		builder.setPath(ApiConfiguration.API_PATH + BittrexApi.GET_MARKET_HISTORY.getUrl());
		builder.addParameter(MARKET_PARAM, market);
		return builder.build().toString();
	}
	
	public String getOrderBook(String market, BittrexOrderType type) throws URISyntaxException {
		URIBuilder builder = new URIBuilder();
		builder.setScheme(scheme);
		builder.setHost(host);
		builder.setPath(ApiConfiguration.API_PATH + BittrexApi.GET_ORDER_BOOK.getUrl());
		builder.addParameter(MARKET_PARAM, market);
		builder.addParameter(ORDER_TYPE_PARAM, type.getType());
		return builder.build().toString();
//		return ApiConfiguration.ROOT_PATH + BittrexApi.GET_ORDER_BOOK.getUrl() + QUESTION_MARK + MARKET_PARAM
//				+ EQUAL_MARK + market;
	}
	
}
