package com.oliver.algorithm.springevent.ordered;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.oliver.algorithm.springevent.PaymentInfo;
import com.oliver.algorithm.springevent.event.PaymentUpdateEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Oliver Wang
 * @description 邮件支付状态监听器--有序
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/18
 * @since
 */
@Component
public class MailPaymentUpdateListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType.isAssignableFrom(PaymentUpdateEvent.class);
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == PaymentInfo.class;
    }

    /**
     * 数值越小 优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        Console.log("邮件服务, 收到支付状态更新的通知. event = {},线程={}",
                JSONUtil.toJsonStr(event.getSource()),Thread.currentThread().getName());
        ( (PaymentInfo)event.getSource()).setId(88888888);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
