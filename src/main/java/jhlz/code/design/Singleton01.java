package jhlz.code.design;

/**
 * 单例模式
 */
public class Singleton01 {
    // volatile 保证指令不会重排序和可见性
    private volatile static Singleton01 INSTANCE = null;

    private Singleton01() {

    }

    public static Singleton01 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton01.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton01();
                }
            }
        }
        return INSTANCE;
    }
}
