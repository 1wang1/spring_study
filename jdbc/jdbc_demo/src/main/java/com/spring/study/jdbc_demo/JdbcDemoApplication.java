package com.spring.study.jdbc_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
@Slf4j
public class JdbcDemoApplication implements CommandLineRunner {

    @Autowired
//    private FooDao fooDao;
            TransactionTemplate transactionTemplate;
    @Autowired
//	private BatchFooDao batchFooDao;
            JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

//    @Bean
//    @Autowired
//    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate template) {
//        return new SimpleJdbcInsert(template).withTableName("FOO").usingGeneratedKeyColumns("ID");
//    }

    @Override
    public void run(String... args) throws Exception {
//    	fooDao.insertData();
//    	batchFooDao.batchInsert();
//    	fooDao.listData();
        log.info("Count Before Transaction:{}", getCount());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.execute("insert into FOO (ID,BAR) VALUES (2,'AAA')");
                log.info("in Transaction:{}",getCount());
                transactionStatus.setRollbackOnly();
            }
        });
        log.info("Count after Transaction:{}",getCount());
    }

    private Long getCount() {
        return (Long) jdbcTemplate.queryForList("select count(1) AS CNT from FOO").get(0)
                .get("CNT");
    }
}
