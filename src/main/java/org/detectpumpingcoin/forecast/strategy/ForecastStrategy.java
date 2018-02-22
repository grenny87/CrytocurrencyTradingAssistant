package org.detectpumpingcoin.forecast.strategy;

import java.util.List;

public interface ForecastStrategy {
	//	frameTimeForecasting in second
	public int frameTimeForecasting = 60;
	
	public int increasementRate = 3;
	
	public List<String> doOperation() ;
}
