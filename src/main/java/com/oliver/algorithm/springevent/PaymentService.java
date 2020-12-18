package com.oliver.algorithm.springevent;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.oliver.algorithm.springevent.event.PaymentUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author Oliver Wang
 * @description 支付逻辑
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/18
 * @since
 */
@Service
public class PaymentService {
    @Autowired
    private ApplicationContext applicationContext;

    public void pay(int id, String status) {
        PaymentInfo paymentInfo = new PaymentInfo(id, status);
        PaymentUpdateEvent paymentUpdateEvent = new PaymentUpdateEvent(paymentInfo);
        Console.log("支付成功。。。。Event={}", JSONUtil.toJsonStr(paymentUpdateEvent.getSource()));
        // 发布事件-PaymentService为事件发布者
        applicationContext.publishEvent(paymentUpdateEvent);
    }

}
