package org.detectpumpingcoin.forecast.context;

import java.util.List;

import org.detectpumpingcoin.forecast.strategy.ForecastStategy;

public class MarketContext {
	
	private ForecastStategy strategy;
	
	public MarketContext(ForecastStategy strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * Execute forecasting base on specific strategy
	 * @return List of Pumping coin
	 */
	public List<String> doForecasting(){
		 return strategy.doOperation();
	}
}
