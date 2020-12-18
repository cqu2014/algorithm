package com.oliver.algorithm.springevent.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Oliver Wang
 * @description 支付状态变更事件
 * @created by IntelliJ IDEA 2020.02
 * @date Create at 2020/12/18
 * @since
 */
public class PaymentUpdateEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PaymentUpdateEvent(Object source) {
        super(source);
    }
}
