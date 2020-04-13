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
                             .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'",
                                             Long.class));
        }

        try {
            // spring 中为类做了一个代理
            //需要调用代理类，才能执行到到被代理类的增强方法
            //如果方法是在类的内部调用的话，意味着没有走到代理方法
            //所以虽然invokeInsertThenRollback调用了一个带有transaction注解的方法
            // 但是因为本身这个方法时没有事务的因此它在调用insertThenRollback的时候也不会有事务的支持
//            spring先创建了自身的实例A，然后再加了一层封装的代理B，
//            Spring Bean注入给其他人时，注入的不是A，而是B。所以通过Bean来调用时，调用的是B.xxx()，
//            在A自身内部调用内部方法时，调用的还是A.xxx()。
            fooService.invokeInsertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}",
                     jdbcTemplate
                             .queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'",
                                             Long.class));
        }
    }
}
