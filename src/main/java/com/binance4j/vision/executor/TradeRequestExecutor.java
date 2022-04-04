package com.binance4j.vision.executor;

import java.util.List;

import com.binance4j.vision.spot.Trade;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * The candlestick request executor
 */
public class TradeRequestExecutor extends VisionRequestExecutor<Trade> {

    public TradeRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    protected List<Trade> csvToObject(List<List<String>> input) {
        return csvToObject(Trade.class, input);
    }
}