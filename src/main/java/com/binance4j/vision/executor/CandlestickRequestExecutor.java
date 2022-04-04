package com.binance4j.vision.executor;

import java.util.List;

import com.binance4j.vision.spot.Candlestick;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * The candlestick request executor
 */
public class CandlestickRequestExecutor extends VisionRequestExecutor<Candlestick> {

    public CandlestickRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    protected List<Candlestick> csvToObject(List<List<String>> input) {
        return csvToObject(Candlestick.class, input);
    }
}