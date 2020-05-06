package com.springstudy.mongodemo;

import com.mongodb.client.result.UpdateResult;
import com.springstudy.mongodemo.converter.MoneyReadConverter;
import com.springstudy.mongodemo.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
public class MongoDemoApplication implements ApplicationRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 2.0))
                .createTime(new Date())
                .updateTime(new Date()).build();
        Coffee saved = mongoTemplate.save(espresso);
        log.info("Coffee:{}", saved);
        // mybatis中，也有criteria的概念，自动生成的Example中会包含Critetia内部类
        List<Coffee> list = mongoTemplate
                .find(Query.query(Criteria.where("name").is("espresso")), Coffee.class);
        log.info("Find:{} Coffee", list.size());
        list.forEach(coffee -> log.info("Coffee:{}", coffee));

        Thread.sleep(1000);
        UpdateResult updateResult =
                mongoTemplate.updateFirst(Query.query(Criteria.where("name").is("espresso")),
                                          new Update().set("price",
                                                           Money.ofMajor(CurrencyUnit.of("CNY"),
                                                                         30))
                                                  .currentDate("updateTime"), Coffee.class);
        log.info("Update Result Count:{}",updateResult.getModifiedCount());
        Coffee updateOne = mongoTemplate.findById(saved.getId(),Coffee.class);
        log.info("Update Result:{}",updateOne);
        mongoTemplate.remove(updateOne);
//        mongoTemplate.find(Query.query(Criteria.where("name").is("adb")).with(Sort.by(Sort.Order.asc("name"))), Coffee.class);
    }

    // 为什么会想到定义这样一个bean？
    // 1. 打开springframework.boot.autocoufigure(org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration)
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Collections.singletonList(new MoneyReadConverter()));
    }
}
