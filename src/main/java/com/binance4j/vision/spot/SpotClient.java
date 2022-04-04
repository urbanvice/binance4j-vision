package com.binance4j.vision.spot;

import com.binance4j.vision.executor.AggTradeRequestExecutor;
import com.binance4j.vision.executor.CandlestickRequestExecutor;
import com.binance4j.vision.executor.TradeRequestExecutor;
import com.binance4j.vision.executor.VisionRequestExecutor;

import retrofit2.Retrofit;

/**
 * The client for retrieving the SPOT public data (trades, aggTrades and klines)
 */
public class SpotClient {
        private final SpotMapping service;

        public SpotClient() {
                service = new Retrofit.Builder()
                                .baseUrl("https://data.binance.vision/data/")
                                .build().create(SpotMapping.class);
        }

        /**
         * Get the compressed csv containing the candlestick data for a
         * symbol (monthly)
         * 
         * @param symbol              The trading pair
         * @param candlestickInterval The interval
         * @param year                The year
         * @param month               The month
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Candlestick> getKlines(String symbol, CandlestickInterval candlestickInterval,
                        String year, String month) {
                return new CandlestickRequestExecutor(
                                service.getMonthlyKlines(symbol.toUpperCase(), candlestickInterval.getValue(), year,
                                                month));
        }

        /**
         * Get the checksum of the zip archive (monthly)
         * 
         * @param symbol              The trading pair
         * @param candlestickInterval The interval
         * @param year                The year
         * @param month               The month
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Candlestick> getKlinesChecksum(String symbol,
                        CandlestickInterval candlestickInterval, String year, String month) {
                return new CandlestickRequestExecutor(
                                service.getMonthlyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.getValue(),
                                                year, month));
        }

        /**
         * Get the compressed csv containing the candlestick data for a
         * symbol (daily)
         * 
         * @param symbol              The trading pair
         * @param candlestickInterval The interval
         * @param year                The year
         * @param month               The month
         * @param day                 The day
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Candlestick> getKlines(String symbol, CandlestickInterval candlestickInterval,
                        String year, String month, String day) {
                return new CandlestickRequestExecutor(
                                service.getDailyKlines(symbol.toUpperCase(), candlestickInterval.getValue(), year,
                                                month, day));
        }

        /**
         * Get the checksum of the zip archive (daily)
         * 
         * @param symbol              The trading pair
         * @param candlestickInterval The interval
         * @param year                The year
         * @param month               The month
         * @param day                 The day
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Candlestick> getKlinesChecksum(String symbol,
                        CandlestickInterval candlestickInterval, String year, String month, String day) {
                return new CandlestickRequestExecutor(
                                service.getDailyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.getValue(),
                                                year,
                                                month, day));
        }

        // Trades

        /**
         * Get the compressed csv containing the trades data for a
         * symbol (monthly)
         * 
         * @param dataInterval The data interval
         * @param symbol       The trading pair
         * @param year         The year
         * @param month        The month
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Trade> getTrades(String symbol, String year, String month) {
                return new TradeRequestExecutor(
                                service.getMonthlyTrades(symbol.toUpperCase(), year, month));
        }

        /**
         * Get the checksum of the zip archive (monthly)
         * 
         * @param dataInterval The data interval
         * @param symbol       The trading pair
         * @param year         The year
         * @param month        The month
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Trade> getTradesChecksum(String symbol, String year, String month) {
                return new TradeRequestExecutor(
                                service.getMonthlyTradesChecksum(symbol.toUpperCase(), year, month));
        }

        /**
         * Get the compressed csv containing the trades data for a
         * symbol (daily)
         * 
         * @param dataInterval        The data interval
         * @param symbol              The trading pair
         * @param candlestickInterval The interval
         * @param year                The year
         * @param month               The month
         * @param day                 The day
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Trade> getTrades(String symbol, String year, String month, String day) {
                return new TradeRequestExecutor(
                                service.getDailyTrades(symbol.toUpperCase(), year, month, day));
        }

        /**
         * Get the checksum of the zip archive (daily)
         * 
         * @param dataInterval The data interval
         * @param symbol       The trading pair
         * @param year         The year
         * @param month        The month
         * @param day          The day
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Trade> getTradesChecksum(String symbol, String year, String month,
                        String day) {
                return new TradeRequestExecutor(
                                service.getDailyTradesChecksum(symbol.toUpperCase(), year, month, day));
        }

        // AggTrades

        /**
         * Get the compressed csv containing the aggTrades data for a
         * symbol (monthly)
         * 
         * @param dataInterval The data interval
         * @param symbol       The trading pair
         * @param year         The year
         * @param month        The month
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<AggTrade> getAggTrades(String symbol, String year, String month) {
                return new AggTradeRequestExecutor(
                                service.getMonthlyAggTrades(symbol.toUpperCase(), year, month));
        }

        /**
         * Get the checksum of the zip archive (monthly)
         * 
         * @param dataInterval The data interval
         * @param symbol       The trading pair
         * @param year         The year
         * @param month        The month
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<AggTrade> getAggTradesChecksum(String symbol, String year, String month) {
                return new AggTradeRequestExecutor(
                                service.getMonthlyAggTradesChecksum(symbol.toUpperCase(), year, month));
        }

        /**
         * Get the compressed csv containing the aggTrades data for a
         * symbol (daily)
         * 
         * @param dataInterval        The data interval
         * @param symbol              The trading pair
         * @param candlestickInterval The interval
         * @param year                The year
         * @param month               The month
         * @param day                 The day
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<AggTrade> getAggTrades(String symbol, String year, String month, String day) {
                return new AggTradeRequestExecutor(
                                service.getDailyAggTrades(symbol.toUpperCase(), year, month, day));
        }

        /**
         * Get the checksum of the zip archive (daily)
         * 
         * @param dataInterval The data interval
         * @param symbol       The trading pair
         * @param year         The year
         * @param month        The month
         * @param day          The day
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<AggTrade> getAggTradesChecksum(String symbol, String year, String month,
                        String day) {
                return new AggTradeRequestExecutor(
                                service.getDailyAggTradesChecksum(symbol.toUpperCase(), year, month, day));
        }
}
