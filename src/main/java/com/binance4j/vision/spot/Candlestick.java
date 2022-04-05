package com.binance4j.vision.spot;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/** The representation of a candlestick */
@Data
@NoArgsConstructor
public class Candlestick {
    /**
     * @return The candlestick open timestamp
     * @param openTime The new value
     */
    private Long openTime;
    /**
     * @return The candlestick close timestamp
     * @param closeTime The new value
     */
    private Long closeTime;
    /**
     * @return The number of trades in this interval
     * @param numberOfTrades The new value
     */
    private Long numberOfTrades;
    /**
     * @return The Open value
     * @param open The new value
     */
    private BigDecimal open;
    /**
     * @return The High value
     * @param high The new value
     */
    private BigDecimal high;
    /**
     * @return The Low value
     * @param low The new value
     */
    private BigDecimal low;
    /**
     * @return The Close value
     * @param close The new value
     */
    private BigDecimal close;
    /**
     * @return The traded volume in the interval
     * @param volume The new value
     */
    private BigDecimal volume;
    /**
     * @return The quote asset traded volume in the interval
     * @param quoteAssetVolume The new value
     */
    private BigDecimal quoteAssetVolume;
    /**
     * @return The taker buy volume
     * @param takerBuyBaseAssetVolume The new value
     */
    private BigDecimal takerBuyBaseAssetVolume;
    /**
     * @return The taker buy quote asset volume
     * @param takerBuyQuoteAssetVolume The new value
     */
    private BigDecimal takerBuyQuoteAssetVolume;
    /**
     * @return ???
     * @param ignore The new value
     */
    private BigDecimal ignore;

    public Candlestick(List<String> input) {
        setOpenTime(Long.parseLong(input.get(0)));
        setOpen(new BigDecimal(input.get(1)));
        setHigh(new BigDecimal(input.get(2)));
        setLow(new BigDecimal(input.get(3)));
        setClose(new BigDecimal(input.get(4)));
        setVolume(new BigDecimal(input.get(5)));
        setCloseTime(Long.parseLong(input.get(6)));
        setQuoteAssetVolume(new BigDecimal(input.get(7)));
        setNumberOfTrades(Long.parseLong(input.get(8)));
        setTakerBuyBaseAssetVolume(new BigDecimal(input.get(9)));
        setTakerBuyQuoteAssetVolume(new BigDecimal(input.get(10)));
        setIgnore(new BigDecimal(input.get(11)));
    }
}
