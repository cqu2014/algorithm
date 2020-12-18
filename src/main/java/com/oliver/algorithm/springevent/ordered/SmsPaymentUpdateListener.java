package com.oliver.algorithm.springevent.ordered;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.oliver.algorithm.springevent.PaymentInfo;
import com.oliver.algorithm.springevent.event.PaymentUpdateEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @author Oliver Wang
 * @description 短信支付状态变更监听器-有序
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/18
 * @since
 */
@Component
public class SmsPaymentUpdateListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType.isAssignableFrom(PaymentUpdateEvent.class);
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == PaymentInfo.class;
    }

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        Console.log("{}--短信服务, 收到支付状态更新的通知. event = {},线程={}",
                Instant.now(),
                JSONUtil.toJsonStr(event.getSource()),Thread.currentThread().getName());
        ((PaymentInfo)event.getSource()).setId(999999);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
