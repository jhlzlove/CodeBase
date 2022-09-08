package jhlz.code.thread;

/**
 * 死锁示例
 */

public class LockTest {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) {
                    System.out.println("sub thread get lock");
                }
            }
        }).start();

        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("main thread run");
            }
        }

        System.out.println("main end");
    }
}
