package com.binance4j.vision.executor;

import java.util.List;

import com.binance4j.core.kline.CandlestickBar;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * The candlestick request executor
 */
public class CandlestickRequestExecutor extends VisionRequestExecutor<CandlestickBar> {

    public CandlestickRequestExecutor(List<Call<ResponseBody>> call) {
        super(call);
    }

    public CandlestickRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    protected List<CandlestickBar> csvToObject(List<List<String>> input) {
        return csvToObject(CandlestickBar.class, input);
    }
}