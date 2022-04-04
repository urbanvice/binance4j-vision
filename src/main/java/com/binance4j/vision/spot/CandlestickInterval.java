package com.binance4j.vision.spot;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** The interval between two candles */
@AllArgsConstructor
public enum CandlestickInterval {
  /** 1 minute interval */
  ONE_MINUTE("1m"),
  /** 3 minutes interval */
  THREE_MINUTES("3m"),
  /** 5 minutes interval */
  FIVE_MINUTES("5m"),
  /** 15 minutes interval */
  FIFTEEN_MINUTES("15m"),
  /** 30 minutes interval */
  HALF_HOURLY("30m"),
  /** 1 hour interval */
  HOURLY("1h"),
  /** 2 hours interval */
  TWO_HOURLY("2h"),
  /** 4 hours interval */
  FOUR_HOURLY("4h"),
  /** 6 hours interval */
  SIX_HOURLY("6h"),
  /** 8 hours interval */
  EIGHT_HOURLY("8h"),
  /** 12 hours interval */
  TWELVE_HOURLY("12h"),
  /** 1 day interval */
  DAILY("1d"),
  /** 3 days interval */
  THREE_DAILY("3d"),
  /** 1 wekk interval */
  WEEKLY("1w"),
  /** 1 month interval */
  MONTHLY("1mo");

  /**
   * @param value The new value
   * @return The interval
   */
  @Getter
  private final String value;
}
