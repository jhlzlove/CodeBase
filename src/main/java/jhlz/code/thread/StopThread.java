package jhlz.code.thread;

import jhlz.code.entity.UserModel;

import java.time.Instant;

/**
 * @author clf
 * @time 2022/8/5 17:26
 * @desc: 使用 stop() 会出现强行终止线程，导致数据不一致。
 */
public class StopThread {
    private static UserModel u = new UserModel();

    /**
     * 改变 u 的值
     */
    public static class ChangeObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    long v = Instant.now().toEpochMilli() / 1000;
                    u.setId(v);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                // 重要的工作已经完成，让出 CPU 资源，给其它重要线程更多的工作机会
                Thread.yield();
            }
        }
    }

    /**
     * 读取 u 的值
     */
    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    if (u.getId() != Integer.parseInt(u.getName())) {
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(1500);
            t.stop();
        }
    }
}
