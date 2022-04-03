package com.binance4j.publicdata.spot;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpotMapping {
    public static final String MONTHLY_KLINES_URL = "spot/monthly/klines/{symbol}/{candlestick_interval}/{symbol}-{candlestick_interval}-{year}-{month}.zip";
    public static final String DAILY_KLINES_URL = "spot/daily/klines/{symbol}/{candlestick_interval}/{symbol}-{candlestick_interval}-{year}-{month}-{day}.zip";

    @GET(MONTHLY_KLINES_URL)
    Call<ResponseBody> getMonthlyKlines(
            @Path("symbol") String symbol,
            @Path("candlestick_interval") String candlestickInterval,
            @Path("year") String year,
            @Path("month") String month);

    @GET(MONTHLY_KLINES_URL + ".CHECKSUM")
    Call<ResponseBody> getMonthlyKlinesChecksum(
            @Path("symbol") String symbol,
            @Path("candlestick_interval") String candlestickInterval,
            @Path("year") String year,
            @Path("month") String month);

    @GET(DAILY_KLINES_URL)
    Call<ResponseBody> getDailyKlines(
            @Path("symbol") String symbol,
            @Path("candlestick_interval") String candlestickInterval,
            @Path("year") String year,
            @Path("month") String month,
            @Path("day") String day);

    @GET(DAILY_KLINES_URL + ".CHECKSUM")
    Call<ResponseBody> getDailyKlinesChecksum(
            @Path("symbol") String symbol,
            @Path("candlestick_interval") String candlestickInterval,
            @Path("year") String year,
            @Path("month") String month,
            @Path("day") String day);
}
