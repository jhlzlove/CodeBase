package org.code.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jhlz
 * @since 2023/5/19 10:23
 */
public class ThreadPool {

    public static ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(2,
                16, 60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>());
    }
}
