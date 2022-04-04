package com.binance4j.vision.spot;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/** The representation of a trade */
@Data
@NoArgsConstructor
public class Trade {
    /**
     * @return The trade id
     * @param tradeId The new value
     */
    private Long tradeId;
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
     * @return The quote asset quantity
     * @param quoteQuantity The new value
     */
    private BigDecimal quoteQuantity;
    /**
     * @return Was it a buyer maker
     * @param isBuyerMaker The new value
     */
    private Boolean isBuyerMaker;
    /**
     * @return Was it the best match?
     * @param isBestMatch The new value
     */
    private Boolean isBestMatch;

    public Trade(List<String> input) {
        setTradeId(Long.parseLong(input.get(0)));
        setPrice(new BigDecimal(input.get(1)));
        setQuantity(new BigDecimal(input.get(2)));
        setQuoteQuantity(new BigDecimal(input.get(3)));
        setTime(Long.parseLong(input.get(4)));
        setIsBuyerMaker(Boolean.parseBoolean(input.get(5)));
        setIsBestMatch(Boolean.parseBoolean(input.get(6)));
    }
}
