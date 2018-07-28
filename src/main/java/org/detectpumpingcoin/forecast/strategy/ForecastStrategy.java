package org.detectpumpingcoin.forecast.strategy;

import java.util.List;

public interface ForecastStrategy {
	//	FrameTime Forecasting in second
	public int getFrametimeForecasting();
	
	public double getIncreasementRate();
	
	public List<String> doOperation() ;
}
