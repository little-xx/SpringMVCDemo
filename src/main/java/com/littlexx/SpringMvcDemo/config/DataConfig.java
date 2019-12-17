package com.littlexx.SpringMvcDemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Configuration
public class DataConfig {

    @Bean
    public DataSource getDataSource(){
        DruidDataSource dataSource= new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("tyx19970802");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springmvcdemo");
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbc(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
