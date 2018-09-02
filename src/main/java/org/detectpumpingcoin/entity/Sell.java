
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
    "Quantity",
    "Rate"
})
public class Sell {

    @JsonProperty("Quantity")
    private double quantity;
    @JsonProperty("Rate")
    private double rate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Quantity")
    public double getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("Rate")
    public double getRate() {
        return rate;
    }

    @JsonProperty("Rate")
    public void setRate(double rate) {
        this.rate = rate;
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
