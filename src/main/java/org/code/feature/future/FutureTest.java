package org.code.feature.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * FutureTest:
 *
 * @author jhlz
 * @since 2022/9/17 17:25:45
 */
public class FutureTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        long startTime = System.nanoTime();

        shop.findPricesByCompletableFuture("MyFavoriteShop");
        System.out.println((System.nanoTime() - startTime) / 1000_000 + " msecs");

    }

    private static void completableFutureTest() {
        Shop shop = new Shop("Shop");

        long startTime = System.nanoTime();
        Future<Double> favorite = shop.getPriceAsync("favorite");
        long invocationTime = (System.nanoTime() - startTime) / 1000_000;
        System.out.println(invocationTime + "msecs");
        // do other something

        // 计算价格的同时
        try {
            Double aDouble = favorite.get();
            System.out.println(aDouble);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime() - startTime) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}
