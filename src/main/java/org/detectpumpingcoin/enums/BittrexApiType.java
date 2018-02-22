package org.detectpumpingcoin.enums;

public enum BittrexApiType {
	PUBLIC("public"),
	ACCOUNT("account"),
	MARKET("market");
	
	private String type;
	
	BittrexApiType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
