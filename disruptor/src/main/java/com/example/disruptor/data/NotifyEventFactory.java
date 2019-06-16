package com.example.disruptor.data;

import com.lmax.disruptor.EventFactory;

public class NotifyEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new NotifyEvent();
    }
}