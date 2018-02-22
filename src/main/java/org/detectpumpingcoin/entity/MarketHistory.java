
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
    "Id",
    "TimeStamp",
    "Quantity",
    "Price",
    "Total",
    "FillType",
    "OrderType"
})
public class MarketHistory {

    @JsonProperty("Id")
    private long id;
    @JsonProperty("TimeStamp")
    private String timeStamp;
    @JsonProperty("Quantity")
    private double quantity;
    @JsonProperty("Price")
    private double price;
    @JsonProperty("Total")
    private double total;
    @JsonProperty("FillType")
    private String fillType;
    @JsonProperty("OrderType")
    private String orderType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Id")
    public long getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("TimeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("TimeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("Quantity")
    public double getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("Price")
    public double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("Total")
    public double getTotal() {
        return total;
    }

    @JsonProperty("Total")
    public void setTotal(double total) {
        this.total = total;
    }

    @JsonProperty("FillType")
    public String getFillType() {
        return fillType;
    }

    @JsonProperty("FillType")
    public void setFillType(String fillType) {
        this.fillType = fillType;
    }

    @JsonProperty("OrderType")
    public String getOrderType() {
        return orderType;
    }

    @JsonProperty("OrderType")
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
