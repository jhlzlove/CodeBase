package jhlz.code.feature.future;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Shop:
 *
 * @author jhlz
 * @since 2022/9/17 17:08:36
 */
public class Shop {

    @Getter
    @Setter
    private String name;

    public Shop(String name) {
        this.name = name;
    }

    private Random random = new Random();

    /**
     * 异步方法
     *
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
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

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
