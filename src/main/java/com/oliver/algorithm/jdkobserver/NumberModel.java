package com.oliver.algorithm.jdkobserver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Oliver Wang
 * @description 取号排队中号码的信息
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/11/9
 * @since 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberModel {
    private int number;
    private String deskType;
}
