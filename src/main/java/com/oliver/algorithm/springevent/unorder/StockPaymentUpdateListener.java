package com.oliver.algorithm.springevent.unorder;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.oliver.algorithm.springevent.PaymentInfo;
import com.oliver.algorithm.springevent.event.PaymentUpdateEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Oliver Wang
 * @description 库存支付状态变更监听器-无序
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/18
 * @since
 */
@Component
public class StockPaymentUpdateListener implements ApplicationListener<PaymentUpdateEvent> {
    @Override
    public void onApplicationEvent(PaymentUpdateEvent event) {
        Console.log("库存服务监听到库存变化：event={}，线程={}", JSONUtil.toJsonStr(event.getSource()),
                Thread.currentThread().getName());
        ((PaymentInfo)event.getSource()).setId(123456);
    }
}
