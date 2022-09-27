package jhlz.code.config;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadConfig:
 *
 * @author jhlz
 * @since 2022/9/21 17:12:01
 */
public class ThreadConfig {

    public static ThreadPoolExecutor threadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10, 100, 1000, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<>()
        );
        return threadPoolExecutor;
    }

}
