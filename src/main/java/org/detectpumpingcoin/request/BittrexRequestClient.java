package org.detectpumpingcoin.request;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.detectpumpingcoin.entity.MarketHistory;
import org.detectpumpingcoin.entity.MarketSummary;
import org.detectpumpingcoin.entity.OrderBook;
import org.detectpumpingcoin.entity.response.BittrexMarketHistotryResponse;
import org.detectpumpingcoin.entity.response.BittrexMarketSummariesResponse;
import org.detectpumpingcoin.entity.response.BittrexOrderBookResponse;
import org.detectpumpingcoin.enums.BittrexOrderType;
import org.detectpumpingcoin.request.generator.BittrexRequestGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BittrexRequestClient extends AbstractRequestClient {

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
		String jsonString = callApi(api);
		marketSummaries.addAll(this.convertJsonStringToMarketSummariesList(jsonString));
		return marketSummaries;

	}

	public List<MarketHistory> getMarketHisotry() throws URISyntaxException {
		List<MarketHistory> marketHistory = new ArrayList<MarketHistory>();
		String api = BittrexRequestGenerator.getInstance().getMarketSummariesRequest();
		String jsonString = callApi(api);
		marketHistory.addAll(this.convertJsonStringToMarketHistoryList(jsonString));
		return marketHistory;

	}

	public OrderBook getOrderBook(String market, BittrexOrderType type) throws URISyntaxException {
		OrderBook orderBook = new OrderBook();
		String api = BittrexRequestGenerator.getInstance().getOrderBook(market, type);
		String jsonString = callApi(api);
		orderBook = this.convertJsonStringToOderBook(jsonString);
		return orderBook;

	}

	private OrderBook convertJsonStringToOderBook(String jsonString) {
		OrderBook orderBook = new OrderBook();
		ObjectMapper mapper = new ObjectMapper();

		BittrexOrderBookResponse result = new BittrexOrderBookResponse();
		try {
			result = mapper.readValue(jsonString, result.getClass());
			orderBook = result.getResult();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot parse json string to OrderBook ", e);
			e.printStackTrace();
		}
		return orderBook;
	}

	private List<MarketHistory> convertJsonStringToMarketHistoryList(String jsonString) {
		List<MarketHistory> marketHistory = new ArrayList<MarketHistory>();
		ObjectMapper mapper = new ObjectMapper();

		BittrexMarketHistotryResponse result = new BittrexMarketHistotryResponse();
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

		BittrexMarketSummariesResponse result = new BittrexMarketSummariesResponse();
		try {
			result = mapper.readValue(jsonString, result.getClass());
			marketSummaries = result.getResult();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot parse json string to MarketSummary list  ", e);
			e.printStackTrace();
		}
		return marketSummaries;
	}

}
