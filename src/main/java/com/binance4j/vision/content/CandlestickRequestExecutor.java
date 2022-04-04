package com.binance4j.vision.content;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.binance4j.vision.spot.Candlestick;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * The candlestick request executor
 */
public class CandlestickRequestExecutor extends BaseVisionRequestExecutor<Candlestick> {

    public CandlestickRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    /**
     * Calls {@link BaseVisionRequestExecutor#getZip()} and extracts the CSV into a
     * list of arrays
     * 
     * @return
     * @throws IOException
     * @throws CsvException
     */
    public List<Candlestick> getData() throws IOException {
        List<String[]> csvs = getCSV();
        List<Candlestick> candlesticks = new LinkedList<>();

        for (String[] csv : csvs) {
            Candlestick candlestick = new Candlestick(csv);
            candlesticks.add(candlestick);
        }
        return candlesticks;
    }
}
