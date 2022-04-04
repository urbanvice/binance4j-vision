package com.binance4j.vision.spot;

import com.binance4j.vision.executor.CandlestickRequestExecutor;
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
         * Gets the zip archive containing the csv containing the candlestick data for a
         * symbol (monthly)
         * 
         * @param dataInterval        The data interval
         * @param symbol              The trading pair
         * @param candlestickInterval The interval
         * @param year                The year
         * @param month               The month
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Candlestick> getKlines(
                        String symbol,
                        CandlestickInterval candlestickInterval,
                        String year,
                        String month) {

                return new CandlestickRequestExecutor(
                                service.getMonthlyKlines(symbol.toUpperCase(), candlestickInterval.getValue(), year,
                                                month));
        }

        /**
         * Gets the checksum of the zip archive (monthly)
         * 
         * @param dataInterval        The data interval
         * @param symbol              The trading pair
         * @param candlestickInterval The interval
         * @param year                The year
         * @param month               The month
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Candlestick> getKlinesChecksum(
                        String symbol,
                        CandlestickInterval candlestickInterval,
                        String year,
                        String month) {

                return new CandlestickRequestExecutor(
                                service.getMonthlyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.getValue(),
                                                year, month));
        }

        /**
         * Gets the zip archive containing the csv containing the candlestick data for a
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
        public VisionRequestExecutor<Candlestick> getKlines(
                        String symbol,
                        CandlestickInterval candlestickInterval,
                        String year,
                        String month,
                        String day) {

                return new CandlestickRequestExecutor(
                                service.getDailyKlines(symbol.toUpperCase(), candlestickInterval.getValue(), year,
                                                month, day));
        }

        /**
         * Gets the checksum of the zip archive (daily)
         * 
         * @param dataInterval        The data interval
         * @param symbol              The trading pair
         * @param candlestickInterval The interval
         * @param year                The year
         * @param month               The month
         * @param day                 The day
         * @return The zip file containing the data
         */
        public VisionRequestExecutor<Candlestick> getKlinesChecksum(
                        String symbol,
                        CandlestickInterval candlestickInterval,
                        String year,
                        String month,
                        String day) {

                return new CandlestickRequestExecutor(
                                service.getDailyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.getValue(),
                                                year,
                                                month, day));
        }
}
