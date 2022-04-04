package com.binance4j.vision.spot;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

/** The representation of a candlestick */
@Data
@NoArgsConstructor
public class Candlestick {
    /**
     * @return The candlestick open timestamp
     * @param OpenTime The new value
     */
    Long openTime;
    /**
     * @return The candlestick close timestamp
     * @param CloseTime The new value
     */
    Long closeTime;
    /**
     * @return The number of trades in this interval
     * @param NumberOfTrades The new value
     */
    Long numberOfTrades;
    /**
     * @return The Open value
     * @param Open The new value
     */
    BigDecimal open;
    /**
     * @return The High value
     * @param High The new value
     */
    BigDecimal high;
    /**
     * @return The Low value
     * @param Low The new value
     */
    BigDecimal low;
    /**
     * @return The Close value
     * @param Close The new value
     */
    BigDecimal close;
    /**
     * @return The traded volume in the interval
     * @param Volume The new value
     */
    BigDecimal volume;
    /**
     * @return The quote asset traded volume in the interval
     * @param QuoteAssetVolume The new value
     */
    BigDecimal quoteAssetVolume;
    /**
     * @return The taker buy volume
     * @param TakerBuyBaseAssetVolume The new value
     */
    BigDecimal takerBuyBaseAssetVolume;
    /**
     * @return The taker buy quote asset volume
     * @param TakerBuyQuoteAssetVolume The new value
     */
    BigDecimal takerBuyQuoteAssetVolume;
    /**
     * @return ???
     * @param Ignore The new value
     */
    BigDecimal ignore;

    public Candlestick(String[] data) {
        setOpenTime(Long.parseLong(data[0]));
        setOpen(new BigDecimal(data[1]));
        setHigh(new BigDecimal(data[2]));
        setLow(new BigDecimal(data[3]));
        setClose(new BigDecimal(data[4]));
        setVolume(new BigDecimal(data[5]));
        setCloseTime(Long.parseLong(data[6]));
        setQuoteAssetVolume(new BigDecimal(data[7]));
        setNumberOfTrades(Long.parseLong(data[8]));
        setTakerBuyBaseAssetVolume(new BigDecimal(data[9]));
        setTakerBuyQuoteAssetVolume(new BigDecimal(data[10]));
        setIgnore(new BigDecimal(data[11]));
    }
}
