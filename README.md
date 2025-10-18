# Iteron

Iteron is a tiny Java framework for asynchronous iteration. It lets you work with sequences, streams, and event-driven data without blocking threads.
The API is simple and composable, so you can produce, transform, and consume data step by step.

## Status

|      | Build Status                                                                                         |
|------|------------------------------------------------------------------------------------------------------|
| main | ![Java CI with Gradle](https://github.com/breuerlukas/iteron/actions/workflows/gradle.yml/badge.svg) |

## Usage

```java
var original = Lists.newArrayList(1, 2, 3);
var futureResponse = AsyncIterator.execute(original, entry ->
  CompletableFuture.completedFuture(entry + 1));
futureResponse.thenAccept(transformed ->
  transformed.forEach(System.out::println)).join();
```

## License

[GPL](https://github.com/breuerlukas/iteron/blob/main/LICENSE.md)