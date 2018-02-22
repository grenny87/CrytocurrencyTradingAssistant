package org.detectpumpingcoin.enums;

public enum BittrexOrderType {
	BOTH("both"),
	SELL("sell"),
	BUY("buy");
	
	private String type;
	BittrexOrderType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
}
