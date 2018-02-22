
package org.detectpumpingcoin.entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "MarketName",
    "High",
    "Low",
    "Volume",
    "Last",
    "BaseVolume",
    "TimeStamp",
    "Bid",
    "Ask",
    "OpenBuyOrders",
    "OpenSellOrders",
    "PrevDay",
    "Created"
})
public class MarketSummary {

    @JsonProperty("MarketName")
    private String marketName;
    @JsonProperty("High")
    private double high;
    @JsonProperty("Low")
    private double low;
    @JsonProperty("Volume")
    private double volume;
    @JsonProperty("Last")
    private double last;
    @JsonProperty("BaseVolume")
    private double baseVolume;
    @JsonProperty("TimeStamp")
    private String timeStamp;
    @JsonProperty("Bid")
    private double bid;
    @JsonProperty("Ask")
    private double ask;
    @JsonProperty("OpenBuyOrders")
    private int openBuyOrders;
    @JsonProperty("OpenSellOrders")
    private int openSellOrders;
    @JsonProperty("PrevDay")
    private double prevDay;
    @JsonProperty("Created")
    private String created;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("MarketName")
    public String getMarketName() {
        return marketName;
    }

    @JsonProperty("MarketName")
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    @JsonProperty("High")
    public double getHigh() {
        return high;
    }

    @JsonProperty("High")
    public void setHigh(double high) {
        this.high = high;
    }

    @JsonProperty("Low")
    public double getLow() {
        return low;
    }

    @JsonProperty("Low")
    public void setLow(double low) {
        this.low = low;
    }

    @JsonProperty("Volume")
    public double getVolume() {
        return volume;
    }

    @JsonProperty("Volume")
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @JsonProperty("Last")
    public double getLast() {
        return last;
    }

    @JsonProperty("Last")
    public void setLast(double last) {
        this.last = last;
    }

    @JsonProperty("BaseVolume")
    public double getBaseVolume() {
        return baseVolume;
    }

    @JsonProperty("BaseVolume")
    public void setBaseVolume(double baseVolume) {
        this.baseVolume = baseVolume;
    }

    @JsonProperty("TimeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("TimeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("Bid")
    public double getBid() {
        return bid;
    }

    @JsonProperty("Bid")
    public void setBid(double bid) {
        this.bid = bid;
    }

    @JsonProperty("Ask")
    public double getAsk() {
        return ask;
    }

    @JsonProperty("Ask")
    public void setAsk(double ask) {
        this.ask = ask;
    }

    @JsonProperty("OpenBuyOrders")
    public int getOpenBuyOrders() {
        return openBuyOrders;
    }

    @JsonProperty("OpenBuyOrders")
    public void setOpenBuyOrders(int openBuyOrders) {
        this.openBuyOrders = openBuyOrders;
    }

    @JsonProperty("OpenSellOrders")
    public int getOpenSellOrders() {
        return openSellOrders;
    }

    @JsonProperty("OpenSellOrders")
    public void setOpenSellOrders(int openSellOrders) {
        this.openSellOrders = openSellOrders;
    }

    @JsonProperty("PrevDay")
    public double getPrevDay() {
        return prevDay;
    }

    @JsonProperty("PrevDay")
    public void setPrevDay(double prevDay) {
        this.prevDay = prevDay;
    }

    @JsonProperty("Created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("Created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Result [marketName=" + marketName + ", high=" + high + ", low=" + low + ", volume=" + volume + ", last="
				+ last + ", baseVolume=" + baseVolume + ", timeStamp=" + timeStamp + ", bid=" + bid + ", ask=" + ask
				+ ", openBuyOrders=" + openBuyOrders + ", openSellOrders=" + openSellOrders + ", prevDay=" + prevDay
				+ ", created=" + created + ", additionalProperties=" + additionalProperties + "]";
	}

}
