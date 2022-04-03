package com.binance4j.publicdata.content;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.binance4j.publicdata.spot.Candlestick;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class CandlestickRequestExecutor extends BaseDataRequestExecutor<Candlestick> {

    public CandlestickRequestExecutor(Call<ResponseBody> call) {
        super(call);
    }

    /**
     * Calls {@link BaseDataRequestExecutor#getZip()} and extracts the CSV into a
     * list
     * of arrays
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
