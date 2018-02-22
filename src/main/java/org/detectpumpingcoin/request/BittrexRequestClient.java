package org.detectpumpingcoin.request;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.detectpumpingcoin.entity.BittrexMarketHistotryReponse;
import org.detectpumpingcoin.entity.BittrexMarketSummariesReponse;
import org.detectpumpingcoin.entity.MarketHistory;
import org.detectpumpingcoin.entity.MarketSummary;
import org.detectpumpingcoin.request.generator.BittrexRequestGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BittrexRequestClient {
	final static Logger logger = Logger.getAnonymousLogger();
	
	private HttpClient httpClient = HttpClientBuilder.create().build();
	private static BittrexRequestClient instance;
	BittrexRequestClient() {
		
	};
	
	public static BittrexRequestClient getInstance() {
		if (instance == null) {
			instance = new BittrexRequestClient();
		}
		return instance;
	}
	
	
	
	public List<MarketSummary> getMarketSummaries() throws URISyntaxException {
		List<MarketSummary> marketSummaries = new ArrayList<MarketSummary>();
		String api = BittrexRequestGenerator.getInstance().getMarketSummariesRequest();
		HttpGet httpGetRequest = new HttpGet(api);
		try {
			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
			System.out.println("----------------------------------------");
			System.out.println(httpResponse.getStatusLine());
			System.out.println("----------------------------------------");

			HttpEntity entity = httpResponse.getEntity();
			String jsonString = this.getJsonStringFromReponse(entity);
			
			marketSummaries.addAll(this.convertJsonStringToMarketSummariesList(jsonString));
			System.out.println(marketSummaries);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot call bittrex api " + api  , e);
			e.printStackTrace();
		} 
		
		return marketSummaries;
 
	}
	
	public List<MarketHistory> getMarketHisotry() throws URISyntaxException {
		List<MarketHistory> marketHistory = new ArrayList<MarketHistory>();
		String api = BittrexRequestGenerator.getInstance().getMarketSummariesRequest();
		HttpGet httpGetRequest = new HttpGet(api);
		try {
			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
			System.out.println("----------------------------------------");
			System.out.println(httpResponse.getStatusLine());
			System.out.println("----------------------------------------");

			HttpEntity entity = httpResponse.getEntity();
			String jsonString = this.getJsonStringFromReponse(entity);
			
			marketHistory.addAll(this.convertJsonStringToMarketHistoryList(jsonString));
			System.out.println(marketHistory);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot call bittrex api " + api  , e);
			e.printStackTrace();
		} 
		
		return marketHistory;
 
	}

	private List<MarketHistory> convertJsonStringToMarketHistoryList(String jsonString) {
		List<MarketHistory> marketHistory = new ArrayList<MarketHistory>();
		ObjectMapper mapper = new ObjectMapper();

		BittrexMarketHistotryReponse result = new BittrexMarketHistotryReponse();
		try {
			result = mapper.readValue(jsonString, result.getClass());
			marketHistory = result.getResult();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot parse json string to MarketSummary list  ", e);
			e.printStackTrace();
		} 
		return marketHistory;
	}

	private List<MarketSummary> convertJsonStringToMarketSummariesList(String jsonString) {
		List<MarketSummary> marketSummaries = new ArrayList<MarketSummary>();
		ObjectMapper mapper = new ObjectMapper();

		BittrexMarketSummariesReponse result = new BittrexMarketSummariesReponse();
		try {
			result = mapper.readValue(jsonString, result.getClass());
			marketSummaries = result.getResult();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot parse json string to MarketSummary list  ", e);
			e.printStackTrace();
		} 
		return marketSummaries;
	}

	private String getJsonStringFromReponse(HttpEntity entity) throws UnsupportedOperationException, IOException {
		StringBuilder builder = new StringBuilder();

		byte[] buffer = new byte[1024];
		if (entity != null) {
			InputStream inputStream = entity.getContent();
			try {
				int bytesRead = 0;
				BufferedInputStream bis = new BufferedInputStream(inputStream);
				while ((bytesRead = bis.read(buffer)) != -1) {
					String chunk = new String(buffer, 0, bytesRead);
					builder.append(chunk);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (Exception ignore) {
				}
			}
		}
		return builder.toString();
	}
	
	
}
