package org.code.feature.future;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Shop:
 *
 * @author jhlz
 * @since 2022/9/17 17:08:36
 */
public class Shop {

    private String name;

    public String getName() {
        return name;
    }

    public Shop setName(String name) {
        this.name = name;
        return this;
    }

    public Random getRandom() {
        return random;
    }

    public Shop setRandom(Random random) {
        this.random = random;
        return this;
    }

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    private Random random = new Random();

    public static final List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll")
    );

    /**
     * completableFuture test
     * 其中，join 操作会阻塞主线程
     *
     * @param product
     * @return
     */
    public List<String> findPricesByCompletableFuture(String product) {
        List<CompletableFuture<String>> collect = shops.stream().map(shop -> {
            return CompletableFuture.supplyAsync(
                    () -> shop.getName() + " price is " + shop.getPrice(product)
            );
        }).collect(Collectors.toList());
        return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    /**
     * stream test
     *
     * @param product
     * @return
     */
    public List<String> findPricesByStream(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * parallelStream test
     *
     * @param product
     * @return
     */
    public List<String> findPricesByParallelStream(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * 异步方法
     *
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
        // 创建 CompletableFuture
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            // 设置价格
            completableFuture.complete(price);
        }).start();
        return completableFuture;
    }

    /**
     * 同步方法
     *
     * @param product
     * @return
     */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * sleep 1s
     */
    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查找商品价格
     *
     * @param product
     * @return
     */
    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
