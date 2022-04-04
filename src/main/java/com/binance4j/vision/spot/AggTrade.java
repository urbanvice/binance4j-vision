package com.binance4j.vision.spot;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/** The representation of an aggregated trade */
@Data
@NoArgsConstructor
public class AggTrade {
    /**
     * @return The trade id
     * @param tradeId The new value
     */
    private Long tradeId;
    /**
     * @return The first trade id
     * @param firstTradeId The new value
     */
    private Long firstTradeId;
    /**
     * @return The last trade id
     * @param lastTradeId The new value
     */
    private Long lastTradeId;
    /**
     * @return The timestamp
     * @param time The new value
     */
    private Long time;
    /**
     * @return The price
     * @param price The new value
     */
    private BigDecimal price;
    /**
     * @return The quantity
     * @param quantity The new value
     */
    private BigDecimal quantity;

    /**
     * @return Was it a buyer maker
     * @param isBuyerMaker The new value
     */
    private Boolean isBuyerMaker;
    /**
     * @return Was it the best price match?
     * @param isBestMatch The new value
     */
    private Boolean isBestMatch;

    public AggTrade(List<String> input) {
        setTradeId(Long.parseLong(input.get(0)));
        setPrice(new BigDecimal(input.get(1)));
        setQuantity(new BigDecimal(input.get(2)));
        setFirstTradeId(Long.parseLong(input.get(3)));
        setLastTradeId(Long.parseLong(input.get(4)));
        setTime(Long.parseLong(input.get(5)));
        setIsBuyerMaker(Boolean.parseBoolean(input.get(6)));
        setIsBestMatch(Boolean.parseBoolean(input.get(7)));
    }
}
