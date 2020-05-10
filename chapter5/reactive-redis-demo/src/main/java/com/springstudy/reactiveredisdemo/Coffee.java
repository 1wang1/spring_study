package com.springstudy.reactiveredisdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：WangZhenkun.
 * @ Create Time       ：  2020/5/10 20:50
 * @ Modify Time       ：  2020/5/10 20:50
 * @ Modified By：
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private Long id;
    private String name;
    private Long price;

}
