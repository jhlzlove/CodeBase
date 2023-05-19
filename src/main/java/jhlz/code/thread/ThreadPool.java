package jhlz.code.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jhlz
 * @since 2023/5/19 10:23
 */
public class ThreadPoolConfig {

    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(1,
                16, 60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), Executors.);
    }
}
