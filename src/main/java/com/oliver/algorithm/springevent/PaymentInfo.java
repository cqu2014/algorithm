package com.oliver.algorithm.springevent;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Oliver Wang
 * @description 支付信息实体
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/18
 * @since
 */
@Data
@AllArgsConstructor
public class PaymentInfo {
    private int id;
    private String status;
}
