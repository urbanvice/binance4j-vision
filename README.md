# binance4j-vision

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.binance4j/binance4j-vision/badge.svg)](https://search.maven.org/search?q=com.binance4j)
[![Sonatype Nexus](https://img.shields.io/nexus/r/com.binance4j/binance4j-vision?server=https%3A%2F%2Fs01.oss.sonatype.org%2F)](https://s01.oss.sonatype.org/#nexus-search;quick~com.binance4j)
![Build Status develop](https://img.shields.io/github/workflow/status/binance4j/binance4j-vision/Deploy%20Artifact%20on%20Maven%20then%20merge%20on%20main/deploy?label=Test)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![JDK](https://upload.wikimedia.org/wikipedia/commons/7/75/Blue_JDK_1.8%2B_Shield_Badge.svg)
[![javadoc](https://img.shields.io/badge/javadoc-latest-informational)](https://binance4j.github.io/binance4j-vision)
[![binance doc](https://img.shields.io/badge/binance%20doc-public%20data-gold)](https://github.com/binance/binance-public-data)

Binance4j-vision helps download Binance public data easily. Only SPOT data is available right now.

## Installation

### Maven

```xml
<dependency>
  <groupId>com.binance4j</groupId>
  <artifactId>binance4j-vision</artifactId>
  <version>1.2.0</version>
</dependency>
```
 
## Usage

### Instantiate the Spot client

```java
SpotClient client = new SpotClient();
```

### Get candlestick data

#### Synchronously

In a zip format

```java
//daily
ZipInputStream zis = client.getKlines(symbol, interval, year, month, day).getZip();
```

```java
//monthly
ZipInputStream zis = client.getKlines(symbol, interval, year, month).getZip();
```

In a table format

```java
//daily
List<List<String>> csv = client.getKlines(symbol, interval, year, month, day).getCSV();
```

```java
//monthly
List<List<String>> csv = client.getKlines(symbol, interval, year, month).getCSV();
```

In a deserialized format

```java
//daily
List<Candlestick> candles = client.getKlines(symbol, interval, year, month, day).getData();
```

```java
//monthly
List<Candlestick> candles = client.getKlines(symbol, interval, year, month).getData();
```

#### Asynchronously

In a zip format

```java
//daily
client.getKlines(symbol, interval, year, month, day).getZip(res->{});
```

```java
//monthly
client.getKlines(symbol, interval, year, month).getZip(res->{});
```

In a table format

```java
//daily
client.getKlines(symbol, interval, year, month, day).getCSV(res->{});
```

```java
//monthly
client.getKlines(symbol, interval, year, month).getCSV(res->{});
```

In a deserialized format

```java
//daily
client.getKlines(symbol, interval, year, month, day).getData(res->{});
```

```java
//monthly
client.getKlines(symbol, interval, year, month).getData(res->{});
```

### Get candlestick data Checksum

```java
//daily

//sync
Checksum checksum = client.getKlinesChecksum(symbol, interval, year, month, day).getChecksum();

//async
client.getKlinesChecksum(symbol, interval, year, month, day).getChecksum(checksum->{});

//monthly

//sync
Checksum checksum = client.getKlinesChecksum(symbol, interval, year, month).getChecksum();
//async
client.getKlinesChecksum(symbol, interval, year, month).getChecksum(checksum->{});
```

### Get Trades data

#### Synchronously

In a zip format

```java
//daily
ZipInputStream zis = client.getTrades(symbol, year, month, day).getZip();
```

```java
//monthly
ZipInputStream zis = client.getTrades(symbol, year, month).getZip();
```

In a table format

```java
//daily
List<List<String>> csv = client.getTrades(symbol, year, month, day).getCSV();
```

```java
//monthly
List<List<String>> csv = client.getTrades(symbol, year, month).getCSV();
```

In a deserialized format

```java
//daily
List<Trade> candles = client.getTrades(symbol, year, month, day).getData();
```

```java
//monthly
List<Trade> candles = client.getTrades(symbol, year, month).getData();
```

#### Asynchronously

In a zip format

```java
//daily
client.getTrades(symbol, year, month, day).getZip(res->{});
```

```java
//monthly
client.getTrades(symbol, year, month).getZip(res->{});
```

In a table format

```java
//daily
client.getTrades(symbol, year, month, day).getCSV(res->{});
```

```java
//monthly
client.getTrades(symbol, year, month).getCSV(res->{});
```

In a deserialized format

```java
//daily
client.getTrades(symbol, year, month, day).getData(res->{});
```

```java
//monthly
client.getTrades(symbol, year, month).getData(res->{});
```

### Get trades data Checksum

```java
//daily

//sync
Checksum checksum = client.getTradesChecksum(symbol, year, month, day).getChecksum();

//async
client.getTradesChecksum(symbol, year, month, day).getChecksum(checksum->{});

//monthly

//sync
Checksum checksum = client.getTradesChecksum(symbol, year, month).getChecksum();
//async
client.getTradesChecksum(symbol, year, month).getChecksum(checksum->{});
```

### Get Aggregated Trades data

#### Synchronously

In a zip format

```java
//daily
ZipInputStream zis = client.getAggTrades(symbol, year, month, day).getZip();
```

```java
//monthly
ZipInputStream zis = client.getAggTrades(symbol, year, month).getZip();
```

In a table format

```java
//daily
List<List<String>> csv = client.getAggTrades(symbol, year, month, day).getCSV();
```

```java
//monthly
List<List<String>> csv = client.getAggTrades(symbol, year, month).getCSV();
```

In a deserialized format

```java
//daily
List<AggTrade> candles = client.getAggTrades(symbol, year, month, day).getData();
```

```java
//monthly
List<AggTrade> candles = client.getAggTrades(symbol, year, month).getData();
```

#### Asynchronously

In a zip format

```java
//daily
client.getAggTrades(symbol, year, month, day).getZip(res->{});
```

```java
//monthly
client.getAggTrades(symbol, year, month).getZip(res->{});
```

In a table format

```java
//daily
client.getAggTrades(symbol, year, month, day).getCSV(res->{});
```

```java
//monthly
client.getAggTrades(symbol, year, month).getCSV(res->{});
```

In a deserialized format

```java
//daily
client.getAggTrades(symbol, year, month, day).getData(res->{});
```

```java
//monthly
client.getAggTrades(symbol, year, month).getData(res->{});
```

### Get aggregated trades data Checksum

```java
//daily

//sync
Checksum checksum = client.getAggTradesChecksum(symbol, year, month, day).getChecksum();

//async
client.getAggTradesChecksum(symbol, year, month, day).getChecksum(checksum->{});

//monthly

//sync
Checksum checksum = client.getAggTradesChecksum(symbol, year, month).getChecksum();
//async
client.getAggTradesChecksum(symbol, year, month).getChecksum(checksum->{});
```
