package jhlz.code;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;

/**
 * 监听文件夹动态：新建、修改、删除（移动）
 *
 * @author jhlz
 * @since 2023/5/18 16:14
 */
public class WatchFolder {
    public static void main(String[] args) {
        String folderPath = "D:\\";
        try {
            // 创建监听服务
            Path path = Paths.get(folderPath);
            WatchService watchService = path.getFileSystem().newWatchService();
            // 为 watchService 注册创建、修改、删除的事件监听类型
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
            System.out.println("监听路径：" + folderPath);

            while (true) {
                // 阻塞等待事件；如果使用 poll 可以自定义等待的超时时间
                WatchKey watchKey = watchService.take();
                // 获取监听的事件列表
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                // 循环获取
                watchEvents.forEach(it -> {
                    if (Objects.equals(StandardWatchEventKinds.ENTRY_CREATE, it.kind())) {
                        System.out.println(it.context() + "被创建了");
                    }
                    if (Objects.equals(StandardWatchEventKinds.ENTRY_MODIFY, it.kind())) {
                        System.out.println(it.context() + "被修改了");
                    }
                    if (Objects.equals(StandardWatchEventKinds.ENTRY_DELETE, it.kind())) {
                        System.out.println(it.context() + "被删除了");
                    }
                });
                // 重置监听
                watchKey.reset();
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
