
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
    "Bid",
    "Ask",
    "Last"
})
public class Ticker {

    @JsonProperty("Bid")
    private double bid;
    @JsonProperty("Ask")
    private double ask;
    @JsonProperty("Last")
    private double last;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("Last")
    public double getLast() {
        return last;
    }

    @JsonProperty("Last")
    public void setLast(double last) {
        this.last = last;
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
