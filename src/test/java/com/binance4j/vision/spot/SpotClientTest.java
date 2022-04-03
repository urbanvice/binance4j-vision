package com.binance4j.vision.spot;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SpotClientTest {
    SpotClient client;

    public SpotClientTest() {
        client = new SpotClient();
    }

    @Test
    void testGetKlines() throws IOException {
        List<Candlestick> candlesticks = client.getKlines("SHIBEUR", CandlestickInterval.ONE_MINUTE,
                "2022", "01", "01").getData();
        candlesticks.forEach(c -> {
            System.out.println(c);
        });
    }
}
