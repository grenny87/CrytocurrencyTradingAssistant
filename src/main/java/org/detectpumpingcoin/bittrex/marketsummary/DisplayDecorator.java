package org.detectpumpingcoin.bittrex.marketsummary;

import org.detectpumpingcoin.entity.MarketSummaryWrapper;

public class DisplayDecorator {
	private Display display;
	
	public DisplayDecorator(Display display) {
		this.display = display;
		
	}
	public void doDisplay(MarketSummaryWrapper marketSummaryWrapper) {
		display.show(marketSummaryWrapper);
		
	}
}
