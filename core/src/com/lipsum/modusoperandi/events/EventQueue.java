package com.lipsum.modusoperandi.events;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventQueue {
    private final ConcurrentLinkedQueue<Event> queue = new ConcurrentLinkedQueue<>();
    private final Set<EventConsumer> consumers = new HashSet<>();
    public static final EventQueue instance = new EventQueue();

    public void invoke(Event event) {
        queue.add(event);
    }

    public boolean handleNext() {
        if (queue.isEmpty()) {
            return false;
        }

        Event event = queue.poll();
        for (EventConsumer consumer :consumers) {
            consumer.handleEvent(event);
        }
        return true;
    }

    public void handleAll() {
        boolean success = true;
        while (success) {
            success = handleNext();
        }
    }

    public void addConsumer(EventConsumer eventConsumer) {
        consumers.add(eventConsumer);
    }
}
