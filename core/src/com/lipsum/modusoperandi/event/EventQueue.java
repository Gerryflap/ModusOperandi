package com.lipsum.modusoperandi.event;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventQueue {
    private final ConcurrentLinkedQueue<Event> queue = new ConcurrentLinkedQueue<>();
    private final Set<EventConsumer> consumers = new HashSet<>();
    private static final EventQueue instance = new EventQueue();

    public void invoke(Event event) {
        queue.add(event);
    }

    public boolean handleNext() {
        if (queue.isEmpty()) {
            return false;
        }

        Event event = queue.poll();

        try {
            for (EventConsumer consumer : consumers) {
                consumer.handleEvent(event);
            }
        } catch (ConcurrentModificationException e) {
            // Maybe fix this error, or not.
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

    public static EventQueue getInstance() {
        return EventQueue.instance;
    }

}
