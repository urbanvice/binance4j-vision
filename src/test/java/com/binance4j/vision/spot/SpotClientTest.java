package com.binance4j.vision.spot;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

public class SpotClientTest {
    SpotClient client;

    public SpotClientTest() {
        client = new SpotClient();
    }

    @Test
    void testGetKlines() throws IOException, InterruptedException, ExecutionException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getKlines("SHIBEUR", CandlestickInterval.ONE_MINUTE, "2022", "01", "01")
                .getData(cb -> {
                    System.out.println("foo");
                    System.out.println(cb);
                    cb.forEach(c -> {
                        System.out.println(c);
                    });
                    future.complete(null);
                });

        assertNull(future.get());

        // List<Candlestick> cb = client.getKlines("SHIBEUR",
        // CandlestickInterval.ONE_MINUTE,
        // "2022", "01", "01").getData();
        // System.out.println(cb);
        // cb.forEach(c -> {
        // System.out.println(c);
        // });
    }
}
