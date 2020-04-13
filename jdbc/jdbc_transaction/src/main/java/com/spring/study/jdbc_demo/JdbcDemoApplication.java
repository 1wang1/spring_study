package com.spring.study.jdbc_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.PROXY)
@Slf4j
public class JdbcDemoApplication implements CommandLineRunner {
    @Autowired
    private FooService fooService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fooService.insertRecord();
        log.info("AAA {}",
                 jdbcTemplate
                         .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));
        try {
            fooService.insertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}",
                     jdbcTemplate
                             .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
        }

        try {
            // 因为该方法没有事务注解，所以不会以事务的方式进行调用；即使内部调用有事务的方法，也不会按照事务的方式执行
            fooService.invokeInsertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}",
                     jdbcTemplate
                             .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
        }
    }
}
