package jhlz.code.resources;

import java.io.File;

/**
 * @author jhlz
 * @time: 2022/8/25 下午9:45
 * @desc: ReaderResources
 */
public class ReaderResources {

    public static void main(String[] args) {

        File is = new File("src/main/resources/img");
        
        System.out.println(is.toPath());
        System.out.println(is.getPath());
        File[] files = is.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 获取文件名称 包括后缀
            System.out.println(files[i].getName());
            // 获取文件绝对路径
            System.out.println(files[i].getAbsoluteFile());
        }
    }
}
