package org.detectpumpingcoin.forecast.context;

import java.util.List;

import org.detectpumpingcoin.forecast.strategy.ForecastStrategy;

public class MarketContext {
	
	private ForecastStrategy strategy;
	
	public MarketContext(ForecastStrategy strategy) {
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
