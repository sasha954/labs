package ua.nure.lab1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataBaseConfig {

    @Value("db.driver")
    private String driver;
    @Value("db.url")
    private String url;
    @Value("db.username")
    private String username;
    @Value("db.password")
    private String password;

    @Bean
    public DataSource dataSourse() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
       /* dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);*/
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
