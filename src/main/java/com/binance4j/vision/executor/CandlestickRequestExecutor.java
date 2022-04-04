package com.binance4j.vision.executor;

import java.io.IOException;
import java.util.List;

import com.binance4j.core.callback.ApiCallback;
import com.binance4j.core.exception.ApiException;
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

    public List<Candlestick> getData() throws IOException {
        return csvToObject(getCSV());
    }

    public void getData(ApiCallback<List<Candlestick>> callback) {
        then(new ApiCallback<ResponseBody>() {

            @Override
            public void onResponse(ResponseBody res) {
                try {
                    callback.onResponse(csvToObject(extractCSV(responseToZip(res))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onFailure(ApiException exception) {
                callback.onFailure(exception);
            }

            @Override
            public void onInternalError() {
                callback.onInternalError();
            }

            @Override
            public void onRateLimitBan() {
                callback.onRateLimitBan();
            }

            @Override
            public void onRateLimitBreak() {
                callback.onRateLimitBreak();
            }

            @Override
            public void onWAFLimit() {
                callback.onWAFLimit();
            }
        });
    }

    protected List<Candlestick> csvToObject(List<List<String>> input) {
        return csvToObject(Candlestick.class, input);
    }
}