package jhlz.code.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author: jhlz
 * @since: 2022/10/23 22:02:32
 */
// @Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String pass;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Bean(name = "data_pgsql")
    public DataSource dataSource() {

        return getDruidDataSource(user, pass, url, driverClassName);
    }

    private DruidDataSource getDruidDataSource(String name, String password, String url, String driver) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(name);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }


}
