package jhlz.code;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jhlz
 * @time: 2022/9/6 下午3:17
 * @desc: CodeBaseApplication
 */
@SpringBootApplication
@MapperScan(basePackages = "jhlz.code.web.mapper")
public class CodeBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeBaseApplication.class, args);
    }
}
