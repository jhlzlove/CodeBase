package jhlz.code.thread;

/**
 * @author clf
 * @time 2022/8/5 18:37
 * @desc: 线程组的简单使用，线程组也有 stop() 方法，它也会遇到和 Thread.stop() 一样的问题。
 * 编码规范：在创建线程的时候，名称的命名如果取得好听，那么不仅有助于解决问题，还会让人心请愉悦。。
 * 至少不会像 Thread-1、Thread-2 这样让人抓狂，但是如果是像 FTPService、HttpHandler 这样，会让人心情倍爽。
 */
public class GroupThread implements Runnable {
    @Override
    public void run() {
        // 组名+线程名
        String groupName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + groupName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个名为 jhlz 的线程组
        ThreadGroup tg = new ThreadGroup("jhlz");
        // 创建线程组的线程
        Thread t1 = new Thread(tg, new GroupThread(), "测试线程T1");
        Thread t2 = new Thread(tg, new GroupThread(), "测试线程T2");
        t1.start();
        t2.start();
        // 获取活动线程的总数，由于线程是动态的，无法确定精确
        System.out.println(tg.activeCount());
        // list() 方法获取所有的线程信息
        tg.list();
    }
}
