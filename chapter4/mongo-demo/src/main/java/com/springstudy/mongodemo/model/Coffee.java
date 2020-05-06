package com.springstudy.mongodemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
// 标明这个类对应的是哪个表(mongodb中用collection表示)，类似jpa的entity注解，标明这是一个实体类
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee {

    @Id
    private String id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
