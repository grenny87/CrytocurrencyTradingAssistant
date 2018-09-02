
package org.detectpumpingcoin.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buy",
    "sell"
})
public class OrderBook {

    @JsonProperty("buy")
    private List<Buy> buy = null;
    @JsonProperty("sell")
    private List<Sell> sell = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("buy")
    public List<Buy> getBuy() {
        return buy;
    }

    @JsonProperty("buy")
    public void setBuy(List<Buy> buy) {
        this.buy = buy;
    }

    @JsonProperty("sell")
    public List<Sell> getSell() {
        return sell;
    }

    @JsonProperty("sell")
    public void setSell(List<Sell> sell) {
        this.sell = sell;
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
