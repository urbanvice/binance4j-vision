package com.binance4j.vision.spot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
                    assertTrue(cb.size() > 0);
                    cb.forEach(c -> {
                        assertNotNull(c.getClose());
                        assertNotNull(c.getCloseTime());
                        assertNotNull(c.getHigh());
                        assertNotNull(c.getIgnore());
                        assertNotNull(c.getLow());
                        assertNotNull(c.getNumberOfTrades());
                        assertNotNull(c.getOpen());
                        assertNotNull(c.getOpenTime());
                        assertNotNull(c.getQuoteAssetVolume());
                        assertNotNull(c.getTakerBuyBaseAssetVolume());
                        assertNotNull(c.getTakerBuyQuoteAssetVolume());
                        assertNotNull(c.getVolume());
                    });
                    future.complete(null);
                });

        assertNull(future.get());
    }

    @Test
    void getTrades() throws IOException, InterruptedException, ExecutionException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getTrades("SHIBEUR", "2022", "01", "01")
                .getData(cb -> {
                    System.out.println(cb);
                    assertTrue(cb.size() > 0);
                    cb.forEach(c -> {
                        assertNotNull(c.getIsBestMatch());
                        assertNotNull(c.getIsBuyerMaker());
                        assertNotNull(c.getPrice());
                        assertNotNull(c.getQuantity());
                        assertNotNull(c.getQuoteQuantity());
                        assertNotNull(c.getTime());
                        assertNotNull(c.getTradeId());
                    });
                    future.complete(null);
                });

        assertNull(future.get());
    }

}
