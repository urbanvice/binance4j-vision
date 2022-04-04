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

    CandlestickInterval interval = CandlestickInterval.ONE_MINUTE;
    String symbol = "SHIBEUR";
    String year = "2022";
    String month = "01";
    String day = "01";

    public SpotClientTest() {
        client = new SpotClient();
    }

    @Test
    void testGetKlines() throws IOException, InterruptedException, ExecutionException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getKlines(symbol, interval, year, month, day)
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
    void testKlinesChecksum() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getKlinesChecksum(symbol, interval, year, month, day).getChecksum(cb -> {
            assertNotNull(cb.getChecksum());
            assertNotNull(cb.getFileName());
            future.complete(null);
        });
        assertNull(future.get());
    }

    @Test
    void testGetTrades() throws IOException, InterruptedException, ExecutionException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getTrades(symbol, year, month, day)
                .getData(cb -> {
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

    @Test
    void testTradesChecksum() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getTradesChecksum(symbol, year, month, day).getChecksum(cb -> {
            assertNotNull(cb.getChecksum());
            assertNotNull(cb.getFileName());
            future.complete(null);
        });
        assertNull(future.get());
    }

    @Test
    void testGetAggTrades() throws IOException, InterruptedException, ExecutionException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getAggTrades(symbol, year, month, day)
                .getData(cb -> {
                    assertTrue(cb.size() > 0);
                    cb.forEach(c -> {
                        assertNotNull(c.getIsBestMatch());
                        assertNotNull(c.getIsBuyerMaker());
                        assertNotNull(c.getPrice());
                        assertNotNull(c.getQuantity());
                        assertNotNull(c.getTime());
                        assertNotNull(c.getTradeId());
                        assertNotNull(c.getFirstTradeId());
                        assertNotNull(c.getLastTradeId());
                    });
                    future.complete(null);
                });

        assertNull(future.get());
    }

    @Test
    void testAggTradesChecksum() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> future = new CompletableFuture<>();
        client.getAggTradesChecksum(symbol, year, month, day).getChecksum(cb -> {
            assertNotNull(cb.getChecksum());
            assertNotNull(cb.getFileName());
            future.complete(null);
        });
        assertNull(future.get());
    }

}
