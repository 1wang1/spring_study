package com.springstudy.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// jpa 注解，注明这个类是一个实体
@Entity
@Table(name = "T_MENU")
@Builder
@Data
// 如果不加callSuper=true,调用toString方法的时候，只会打印当前类的属性
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Coffee extends BaseEntity implements Serializable {

    private String name;

    @Column
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount", parameters = {
            @org.hibernate.annotations.Parameter(name = "currentCode", value = "CNY")})
    // PersistentMoneyMinorAmount: $100.34 will be stored as 10034.
    // 使用PersistentMoneyMinorAmount后，数据库会定义为bigint
    private Money price;

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    // strategy = GenerationType.IDENTITY 加入后，不会创建sequence，而是使用数据库默认的 IDENTITY
//    private Long id;

// 继承父类
//    @Column(updatable = false)
//    @CreationTimestamp
//    private Date createTime;
//
//    @UpdateTimestamp
//    private Date updateTime;

}
